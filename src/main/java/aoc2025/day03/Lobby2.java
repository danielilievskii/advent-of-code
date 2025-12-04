package aoc2025.day03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Lobby2 {

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

    Deque<Integer> joltagesDeque = new ArrayDeque<>();
    int toRemove = batteries.length - 12;

    for (char battery : batteries) {
      int joltage = Character.getNumericValue(battery);

      while (!joltagesDeque.isEmpty() && toRemove > 0 && joltage > joltagesDeque.peek()) {
        joltagesDeque.pop();
        toRemove--;
      }

      joltagesDeque.push(joltage);
    }

    while (toRemove > 0) {
      joltagesDeque.pop();
      toRemove--;
    }

    StringBuilder sb = new StringBuilder();
    while (!joltagesDeque.isEmpty()) {
      sb.append(joltagesDeque.removeLast());
    }

    return Long.parseLong(sb.toString());
  }

  public static void main(String[] args) {

    Lobby2 ex = new Lobby2();
    Long result = ex.solution("input.txt");
    System.out.println(result);
  }
}