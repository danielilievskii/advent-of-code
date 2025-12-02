package aoc2025.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.LongStream;

public class GiftShop2 {

  public Long solution(String filename) throws IOException {

    InputStream is = getClass().getResourceAsStream(filename);
    String line = new BufferedReader(new InputStreamReader(is)).readLine();

    List<String> ranges = List.of(line.split(","));

    return ranges.stream()
      .flatMapToLong(range -> {
        String[] parts = range.split("-");

        long start = Long.parseLong(parts[0]);
        long end = Long.parseLong(parts[1]);

        return LongStream.rangeClosed(start, end);
      })
      .filter(this::isIdInvalid)
      .sum();
  }

  public boolean isIdInvalid(long id) {
    String idStr = String.valueOf(id);
    int len = idStr.length();

    for (int divisor = 1; divisor <= len/2; divisor++) {
      if (len % divisor != 0) continue;

      String firstSegment = idStr.substring(0, divisor);
      boolean allEqual = true;

      for (int i = divisor; i < len; i += divisor) {
        String segment = idStr.substring(i, i + divisor);

        if (!segment.equals(firstSegment)) {
          allEqual = false;
          break;
        }
      }

      if (allEqual) return true;
    }

    return false;
  }

  public boolean isIdInvalid2(long id) {
    String idStr = String.valueOf(id);
    String repeated = idStr + idStr;
    String trimmed = repeated.substring(1, repeated.length() - 1);

    return trimmed.contains(idStr);
  }

  public static void main(String[] args) throws IOException {
    GiftShop2 ex = new GiftShop2();
    Long result = ex.solution("input.txt");
    System.out.println(result);
  }
}