package aoc2025.day01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class SecretEntrance2 {

  public int solution(String filename) {

    int zeroHits = 0;
    int point = 50;

    InputStream is = getClass().getResourceAsStream(filename);
    List<String> lines = new BufferedReader(new InputStreamReader(is)).lines().toList();

    for(String line : lines) {
      char direction = line.charAt(0);

      int rotation = Integer.parseInt(line.substring(1));
      int normalizedRotation = rotation % 100;

      if (direction == 'L') {
        if (point - rotation <= 0) {
          zeroHits += Math.abs(point - rotation) / 100 + 1;
          if (point == 0) zeroHits--;
        }

        point -= normalizedRotation;
        if(point < 0) point += 100;

      } else {
        if (point + rotation > 99)
          zeroHits += (point + rotation) / 100;

        point += normalizedRotation;
        if (point > 99) point -= 100;
      }
    }

    return zeroHits;
  }

  public static void main(String[] args) {

    SecretEntrance2 ex = new SecretEntrance2();
    int result = ex.solution("input.txt");
    System.out.println(result);
  }
}
