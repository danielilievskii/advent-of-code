package aoc2025.day05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafeteria2 {

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

    List<Range> ranges = new ArrayList<>();

    for (String line : lines) {
      if (line.isEmpty()) break;

      String[] rangeParts = line.split("-");
      long start = Long.parseLong(rangeParts[0]);
      long end = Long.parseLong(rangeParts[1]);

      ranges.add(new Range(start, end));
    }

    ranges.sort(Comparator.comparing(r -> r.start));

    List<Range> merged = new ArrayList<>();
    Range prev = ranges.get(0);

    for(int i=1; i<ranges.size(); i++) {
      Range current = ranges.get(i);

      if(current.start <= prev.end + 1) {
        prev.end = Math.max(prev.end, current.end);
      } else {
        merged.add(prev);
        prev = current;
      }
    }
    merged.add(prev);

    long uniqueIds = 0;
    for (Range range : merged) {
      uniqueIds += (range.end - range.start + 1);
    }

    return uniqueIds;
  }

  public static void main(String[] args) {
    Cafeteria2 ex = new Cafeteria2();
    System.out.println(ex.solution("input.txt"));
  }
}
