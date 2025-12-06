package aoc2025.day05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cafeteria {

  static class Range {
    long start;
    long end;

    Range(long s, long e) {
      this.start = s;
      this.end = e;
    }

    boolean contains(long x) {
      return x >= start && x <= end;
    }
  }

  public long solution(String filename) {

    InputStream is = getClass().getResourceAsStream(filename);
    List<String> lines = new BufferedReader(new InputStreamReader(is)).lines().toList();

    boolean flag = false;
    List<Range> ranges = new ArrayList<>();
    long freshIngredients = 0;

    for (String line : lines) {
      if (line.isEmpty()) {
        flag = true;
        continue;
      }

      if (!flag) {
        String[] rangeParts = line.split("-");
        long start = Long.parseLong(rangeParts[0]);
        long end = Long.parseLong(rangeParts[1]);

        ranges.add(new Range(start, end));
      } else {
        long id = Long.parseLong(line);

        for (Range r : ranges) {
          if (r.contains(id)) {
            freshIngredients++;
            break;
          }
        }
      }
    }

    return freshIngredients;
  }

  public static void main(String[] args) {
    Cafeteria ex = new Cafeteria();
    System.out.println(ex.solution("input.txt"));
  }
}
