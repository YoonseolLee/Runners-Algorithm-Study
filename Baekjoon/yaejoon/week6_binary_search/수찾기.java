//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class 수찾기 {
//
//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    int n = Integer.parseInt(br.readLine());
//    String[] m = br.readLine().split(" ");
//    Arrays.sort(m);
//    int num = Integer.parseInt(br.readLine());
//    String[] l = br.readLine().split(" ");
//
//    for (int i = 0; i < num; i++) {
//      int left = 0;
//      int right = n;
//      while (left!=right) {
//        int mid = (left + right) / 2;
//        if (Integer.parseInt(m[mid]) > Integer.parseInt(l[i])) {
//          right = mid-1;
//        } else if (Integer.parseInt(m[mid]) < Integer.parseInt(l[i])) {
//          left = mid+1;
//        } else {
//          System.out.println(1);
//          break;
//        }
//        if (left==right) {
//          System.out.println(0);
//          break;
//        }
//      }
//    }
//  }
//}
//
