package aoc2025.day04;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class PrintingDepartment {

  private static final int[][] DIRECTIONS = {
    {-1, -1}, {-1, 0}, {-1, 1}, // top left, top, top right
    {0, -1}, {0, 1}, // left, right
    {1, -1}, {1, 0}, {1, 1} // bottom left, bottom, bottom right
  };

  public long solution(String filename) {

    InputStream is = getClass().getResourceAsStream(filename);
    List<String> grid = new BufferedReader(new InputStreamReader(is)).lines().toList();

    int rows = grid.size();
    int cols = grid.get(0).length();

    long accessiblePapers = 0;

    for (int i = 0; i < rows; i++) {
      char[] row = grid.get(i).toCharArray();

      for (int j = 0; j < cols; j++) {
        if (row[j] != '@') continue;

        int neighborPapers = 0;

        for (int[] d : DIRECTIONS) {
          int ni = i + d[0];
          int nj = j + d[1];

          if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
            if (grid.get(ni).charAt(nj) == '@') {
              neighborPapers++;
            }
          }
        }

        if (neighborPapers < 4) accessiblePapers++;
      }
    }

    return accessiblePapers;
  }

  public static void main(String[] args) {
    PrintingDepartment ex = new PrintingDepartment();
    System.out.println(ex.solution("input-sample.txt"));
  }
}
