import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 장난감경주 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testNum = Integer.parseInt(br.readLine());
    for (int i = 0; i < testNum; i++) {
      String[] NXY = br.readLine().split(" ");
      int n = Integer.parseInt(NXY[0]);
      int x = Integer.parseInt(NXY[1]);
      int y = Integer.parseInt(NXY[2]);

      String[] v = br.readLine().split(" ");
      int vN = Integer.parseInt(v[n - 1]);
      v[n - 1] = "0";
      Arrays.sort(v);
      int vMax = Integer.parseInt(v[n - 1]);
      double minTime = (double) x / (double) vMax;

      if (x >= vN * minTime) {
        double minLength = x - vN * minTime;
        if (y >= vN + minLength + 1) {
          int answer = vN + (int) minLength + 1;
          System.out.println(answer);
        } else {
          System.out.println(-1);
        }
      } else {
        System.out.println(0);
      }
    }
  }
}
