package Baekjoon.yoonseol.week2_recursion;

import java.io.*;

public class 재귀의_귀재 {
    static int count = 0;

    public static int recursion(String s, int l, int r) {
        count++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            count = 0; // !!각 문자열을 검사하기 전에 count를 0으로 초기화!!
            String s = br.readLine();
            int palindrome = isPalindrome(s);
            bw.write(palindrome + " " + count);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
