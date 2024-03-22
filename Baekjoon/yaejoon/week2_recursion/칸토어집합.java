import java.io.*;

public class 칸토어집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input ="";

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);

            if (n == 0) {
                bw.write("-");

            } else {
                bw.write(recursion(n));
            }
            bw.write("\n");
            bw.flush();
        }
    }
    public static String recursion (int n) {
        int num = 1;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            num = 3 * num;
        }
        if(n==1) {
            for (int i = 1; i < 3 + 1; i++) {
                if ((i - 1) == 1) {
                    answer.append(" ");
                } else {
                    answer.append("-");
                }
            }
        }else{
            for(int i=1; i<3+1;i++){
                if((i-1)==1){
                    for(int l=0;l<num/3;l++) {
                        answer.append(" ");
                    }
                }else{
                    answer.append(recursion(n-1));
                }
            }
        }
        return answer.toString();
    }
}


