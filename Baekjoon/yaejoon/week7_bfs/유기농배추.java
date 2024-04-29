import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유기농배추 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int test = Integer.parseInt(br.readLine());

    for (int i = 0; i < test; i++) {
      String[] a = br.readLine().split(" ");
      int row = Integer.parseInt(a[0]);
      int column = Integer.parseInt(a[1]);
      int num = Integer.parseInt(a[2]);
      int[][] s = new int[row][column];

      for (int l = 0; l < num; l++) {
        String[] b = br.readLine().split(" ");
        int valueRow = Integer.parseInt(b[0]);
        int valueColumn = Integer.parseInt(b[1]);
        s[valueRow][valueColumn] = 1;
      }
      int count =0;
      for(int m=0; m<row;m++){
        for(int n=0;n<column;n++){
          if(s[m][n]==1) {
            count++;
            dfs(m, n, s);
          }
        }
      }
      System.out.println(count);
    }


  }


  public static void dfs( int a, int b, int[][] maps) {

    maps[a][b]=0;

    if (a+1 < maps.length) {
      if (maps[a + 1][b] == 1) {
        dfs( a + 1, b, maps);
      }
    }
    if (b+1< maps[0].length) {
      if (maps[a][b + 1] == 1 ) {
        dfs( a, b + 1, maps);
      }
    }
    if (a > 0) {
      if (maps[a - 1][b] == 1 ) {
        dfs( a - 1, b, maps);
      }
    }
    if (b > 0) {
      if (maps[a][b - 1] == 1) {
        dfs( a, b - 1, maps);
      }
    }

  }

}


