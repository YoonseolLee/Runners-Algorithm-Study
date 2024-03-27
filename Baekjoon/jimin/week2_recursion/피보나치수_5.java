package Baekjoon.jimin.week2_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수_5 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n < 2) {
            System.out.println(n);
        } else {
            int[] memo = new int[n + 1];
            memo[0] = 0;
            memo[1] = 1;
            System.out.println(fibonacci(n, memo));
        }
    }

    static int fibonacci(int count, int[] memo) {
        memo[n - (count - 2)] = memo[n - count] + memo[n - (count - 1)];

        if (count <= 2) {
            return memo[n - (count - 2)];
        }

        return fibonacci(count - 1, memo);
    }
}
