package aoc2025.day01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class SecretEntrance {

  public int solution(String filename) {

    int zeroHits = 0;
    int point = 50;

    InputStream is = getClass().getResourceAsStream(filename);
    List<String> lines = new BufferedReader(new InputStreamReader(is)).lines().toList();

    for(String line : lines) {
      char direction = line.charAt(0);
      int rotations = Integer.parseInt(line.substring(1));

      int normalizedRotations = rotations % 100;

      if(direction == 'L') {
        point -= normalizedRotations;
        if(point < 0) point += 100;
      } else if(direction == 'R') {
        point += normalizedRotations;
        if(point > 99) point -= 100;
      }

      if (point == 0) zeroHits++;
    }

    return zeroHits;
  }

  public static void main(String[] args) {

    SecretEntrance ex = new SecretEntrance();
    int result = ex.solution("input.txt");
    System.out.println(result);
  }
}
