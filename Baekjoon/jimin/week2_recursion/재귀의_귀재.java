package Baekjoon.jimin.week2_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class 재귀의_귀재 {
    public static String recursion(String s, int l, int r, int count) {
        if (l >= r) return "1 " + count;  //true
        else if (s.charAt(l) != s.charAt(r)) return "0 " + count;  //false
        else return recursion(s, l + 1, r - 1, count + 1);
    }

    public static String isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] cases = new String[T];

        for (int i = 0; i < T; i++) {
            cases[i] = br.readLine();
        }

        Stream.of(cases).forEach((str) -> System.out.println(isPalindrome(str)));
    }

}
