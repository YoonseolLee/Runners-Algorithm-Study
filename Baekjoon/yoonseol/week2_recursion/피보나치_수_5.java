package Baekjoon.yoonseol.week2_recursion;

import java.io.*;

public class 피보나치_수_5 {
    private static long[] fibonacciCache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        /**
         * fibonacciCache = new long[n+1]; 에 n이 아닌 n+1를 하는 이유는 아래와 같다.
         * 만약 fibonacci(3)을 구하고자 할 때, fibonacciCache에 [0,1,1,2] 가 저장될 것이다.
         * 이 때, fibonacciCache의 size는 !!4!! 이므로 n+1을 해주어야만 한다.
         */
        fibonacciCache = new long[n + 1];
        long result = fibonacci(n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    static long fibonacci(int n) {
        // base case
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        /** 또는 아래로도 작성할 수 있다.
        if (n <= 0) {
            return n;
        }
         */

        // recursive case
        if (fibonacciCache[n] != 0) {
            // fibonacciCache에 값이 있다면, 거기에서 꺼내서 반환하라
            return fibonacciCache[n];
        }

        // fibonacciCache에 값이 없다면, 계산 후 저장하라.
        fibonacciCache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fibonacciCache[n];
    }
}
