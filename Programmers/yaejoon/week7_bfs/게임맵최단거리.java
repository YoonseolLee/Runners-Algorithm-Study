import java.util.Arrays;

public class 게임맵최단거리{

  static int dfss =1;
  static int answer =25;

  public static void main(String[] args) {
    int[][] map = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    int solution = solution(map);
    System.out.println(solution);
  }

  public static int solution(int[][] maps) {
    dfs(dfss, 0, 0, maps);
    return answer;
  }

  public static void dfs(int dfs1, int a, int b, int[][] maps) {

    maps[a][b]=0;
    int[][] road = Arrays.stream(maps)
        .map(int[]::clone)
        .toArray(int[][]::new);

    if (a < 4) {
      if (maps[a + 1][b] == 1) {
        dfs(dfs1+1, a + 1, b, road);
      }
    }
    if (b < 4) {
      if (maps[a][b + 1] == 1 ) {
        dfs(dfs1+1, a, b + 1, road);
      }
    }
    if (a > 0) {
      if (maps[a - 1][b] == 1 ) {
        dfs(dfs1+1, a - 1, b, road);
      }
    }
    if (b > 0) {
      if (maps[a][b - 1] == 1) {
        dfs(dfs1+1, a, b - 1, maps);
      }
    }
    if (a == 4 && b == 4) {
      answer = Math.min(dfs1,answer);
    }
  }
}

