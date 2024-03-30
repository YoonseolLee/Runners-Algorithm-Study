import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 덱 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int commandNum=Integer.parseInt(br.readLine());
    List<String> sb = new ArrayList<>();

    for(int l=0;l<commandNum+1;l++){
      String command = br.readLine();
      String[] b = command.split(" ");

      if(!sb.isEmpty()) {

        if(b[0].equals("push_back")){
          sb.add(b[1]);
        }else if(b[0].equals("push_front")){
          sb.add(0,b[1]);
        }else if(command.equals("size")) {
          System.out.println(sb.size());
        }else if (command.equals("pop_front")) {
          String a = sb.remove(0);
          System.out.println(a);
        } else if (command.equals("pop_back")) {
          String c= sb.remove(sb.size()-1);
          System.out.println(c);
        } else if (command.equals("empty")) {
          System.out.println("0");
        } else if (command.equals("front")) {
          System.out.println(sb.get(0));
        } else if (command.equals("back")) {
          System.out.println(sb.get(sb.size()-1));
        }

      }else if(sb.isEmpty()) {

        if(b[0].equals("push_back")){
          sb.add(b[1]);
        }else if(b[0].equals("push_front")){
          sb.add(0,b[1]);
        }else if(command.equals("size")) {
          System.out.println(0);
        }else if (command.equals("pop_front")) {
          System.out.println(-1);
        } else if (command.equals("pop_back")) {
          System.out.println(-1);
        } else if (command.equals("empty")) {
          System.out.println(1);
        } else if (command.equals("front")) {
          System.out.println(-1);
        } else if (command.equals("back")) {
          System.out.println(-1);
        }

      }
    }
  }
}
