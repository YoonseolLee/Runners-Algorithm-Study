package Baekjoon.jimin.week2_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 칸토어_집합 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = br.readLine()) != null) { //입력이 끝날 때까지
            int N = Integer.parseInt(input);
            int length = (int) Math.pow(3, N);

            for (int i = 0; i < length; i++) {
                sb.append("-");
            }

            func(length, 0);
            System.out.println(sb);
            sb.delete(0, length);
        }
    }

    static void func(int length, int startIndex) {
        if (length <= 1) return;

        int divideLength = length / 3;
        for (int i = divideLength + startIndex; i < divideLength * 2 + startIndex; i++) {
            sb.setCharAt(i, ' ');
        }

        func(divideLength, startIndex);
        func(divideLength, startIndex + divideLength * 2);
    }
}
