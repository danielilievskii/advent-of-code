package aoc2025.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.LongStream;

public class GiftShop {

  public long solution(String filename) throws IOException {

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

    if(idStr.length() % 2 != 0)
      return false;

    int splitIndex = idStr.length() / 2;
    String firstHalf = idStr.substring(0, splitIndex);
    String secondHalf = idStr.substring(splitIndex);

    return firstHalf.equals(secondHalf);
  }

  public static void main(String[] args) throws IOException {

    GiftShop ex = new GiftShop();
    Long result = ex.solution("input.txt");
    System.out.println(result);
  }
}
