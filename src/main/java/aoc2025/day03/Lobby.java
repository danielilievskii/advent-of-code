package aoc2025.day03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Lobby {

  public long solution(String filename) {

    InputStream is = getClass().getResourceAsStream(filename);
    List<String> banks = new BufferedReader(new InputStreamReader(is)).lines().toList();

    return banks
      .stream()
      .mapToLong(bank -> calculateMaxJoltage(bank.toCharArray()))
      .sum();
  }

  // O(N)
  public long calculateMaxJoltage(char[] batteries) {

    int firstBatteryJoltage = 0;
    int secondBatteryJoltage = 0;

    for (char battery : batteries) {
      int joltage = Character.getNumericValue(battery);

      if (joltage > secondBatteryJoltage) {
        if (firstBatteryJoltage == 0) {
          firstBatteryJoltage = joltage;
        } else {
          int tmp = secondBatteryJoltage;
          secondBatteryJoltage = joltage;
          if (tmp > firstBatteryJoltage) {
            firstBatteryJoltage = tmp;
          }
        }
      } else if (secondBatteryJoltage > firstBatteryJoltage) {
        firstBatteryJoltage = secondBatteryJoltage;
        secondBatteryJoltage = joltage;
      }
    }

    return (firstBatteryJoltage * 10L) + secondBatteryJoltage;
  }

  // O(N)
  public long calculateMaxJoltage2(char[] batteries) {

    int firstBatteryJoltage = 0;
    int firstBatteryIndex = -1;

    for (int i = 0; i < batteries.length-1; i++) {
      int joltage = Character.getNumericValue(batteries[i]);

      if(joltage > firstBatteryJoltage) {
        firstBatteryJoltage = joltage;
        firstBatteryIndex = i;
      }
    }

    int secondBatteryJoltage = 0;

    for (int i = firstBatteryIndex; i < batteries.length; i++) {
      int joltage = Character.getNumericValue(batteries[i]);
      if(joltage > secondBatteryJoltage) {
        secondBatteryJoltage = joltage;
      }
    }

    return (firstBatteryJoltage * 10L) + secondBatteryJoltage;
  }



  public static void main(String[] args) {

    Lobby ex = new Lobby();
    Long result = ex.solution("input.txt");
    System.out.println(result);
  }
}