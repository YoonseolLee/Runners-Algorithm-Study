import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    int[] key = new int[num];
    int[] value = new int[num];
    for (int i = 0; i < num; i++) {
      String[] number = br.readLine().split(" ");
      key[i] = Integer.parseInt(number[0]);
      value[i] = Integer.parseInt(number[1]);
    }

    int[] a = new int[num+1];

    for (int i = 0; i <num;i++ ) {

      if (i+key[i] <= num) {
        a[i + key[i]] = Math.max(a[i + key[i]], a[i] + value[i]);
      }
      a[i+1]=Math.max(a[i+1],a[i]);
    }
    System.out.println(a[num]);
  }
}

