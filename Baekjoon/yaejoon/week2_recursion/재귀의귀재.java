import java.io.*;

public class 재귀의귀재 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            String s = br.readLine();
            int[] answer = recursion(s, 0, s.length() - 1, 1);
            bw.write(answer[0]+" "+answer[1]+"\n");
            bw.flush();
        }

    }


    public static int[] recursion(String s, int l, int r,int m){
        int[] result = new int[2];
        result[1]=m;
        if(l >= r) {
            result[0]=1;
            return result;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            result[0] = 0;
            return result;
        }
        else {
            m++;
            return recursion(s, l + 1, r - 1, m);
        }
    }
}