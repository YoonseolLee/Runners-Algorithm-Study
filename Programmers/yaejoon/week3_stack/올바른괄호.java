import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 올바른괄호 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    String a = br.readLine();
     boolean b = solution(a);
    System.out.println(b);
  }
    public static boolean solution (String s){
      boolean answer = true;
      String[] a = s.split("");
      int count = 0;
      for (int i = 0; i < a.length; i++) {
        if (a[i].equals("(")) {
          count++;
        } else if (a[i].equals(")")) {
          count--;
        }
        if (count < 0) {
          answer = false;
          break;
        }
      }

      if (count != 0) {
        answer = false;
      }
      return answer;
    }

}
