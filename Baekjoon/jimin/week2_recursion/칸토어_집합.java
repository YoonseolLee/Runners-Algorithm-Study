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

            sb.setLength(0);
            for (int i = 0; i < length; i++) {
                sb.append("-");
            }

            func(length, 0);
            System.out.println(sb);
        }
    }

    static void func(int length, int startIndex) {
        if (length <= 1) return;

        //수정 부분
        int divideLength = length / 3;
        int startBlank = startIndex + divideLength;
        int endBlank = startIndex + divideLength * 2;

        for (int i = startBlank; i < endBlank; i++) {
            sb.setCharAt(i, ' ');
        }

        func(divideLength, startIndex);
        func(divideLength, endBlank);
    }
}
