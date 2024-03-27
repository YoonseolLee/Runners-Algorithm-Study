package Baekjoon.yoonseol.week2_recursion;

import java.io.*;

public class 칸토어집합 {

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;

        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            int len = (int) Math.pow(3, n);

            sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append("-");
            }

            func(0, len);
            bw.write(String.valueOf(sb));
        }
    }

    public static void func(int start, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;

        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            sb.setCharAt(i, ' ');
        }

        func(start, newSize);
        func(start + 2 * newSize, newSize);
    }
}
