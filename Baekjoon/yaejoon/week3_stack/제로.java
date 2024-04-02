import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 제로 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    List<Integer> number = new ArrayList<>();

    for (int i = 0; i < num; i++) {
      Integer m = Integer.parseInt(br.readLine());
      if (m == 0) {
        number.remove(number.size() - 1);
      } else {
        number.add(m);
      }

    }
    int answer = 0;
    for (int i = 0; i < number.size(); i++) {
      answer += number.get(i);
    }
    System.out.println(answer);
  }
}
