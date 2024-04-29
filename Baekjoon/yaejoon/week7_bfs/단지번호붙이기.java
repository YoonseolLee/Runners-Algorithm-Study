import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단지번호붙이기{

  static int count = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    String[][] test = new String[m][m];
    for (int i = 0; i < m; i++) {
      String[] row = br.readLine().split("");
      test[i] = row;
    }
    List<Integer> answer = new ArrayList<>();
    int check = 0;
    for (int i = 0; i < m; i++) {
      for (int l = 0; l < m; l++) {
        if (test[i][l].equals("1")) {
          check++;
          bfs(i, l, test);
          answer.add(count);
          count=1;
        }
      }
    }
    System.out.println(check);
    int[] array = answer.stream().mapToInt(Integer::intValue).toArray();
    Arrays.sort(array);
    for (int a : array) {
      System.out.println(a);
    }
  }

  public static void bfs(int a, int b, String[][] map) {
    map[a][b] = "0";
    if (a + 1 < map.length) {
      if (map[a + 1][b].equals("1")) {
        count++;
        bfs(a + 1, b, map);
      }

    }
    if (b + 1 < map[0].length) {
      if (map[a][b + 1].equals("1")) {
        count++;
        bfs(a, b + 1, map);
      }
    }
    if (a > 0) {
      if (map[a - 1][b].equals("1")) {
        count++;
        bfs(a - 1, b, map);
      }
    }

    if (b > 0) {
      if (map[a][b - 1].equals("1")) {
        count++;
        bfs(a, b - 1, map);
      }
    }
  }
}
