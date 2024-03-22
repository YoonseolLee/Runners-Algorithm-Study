package Baekjoon.jimin.week2_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 2) {
            System.out.println(n);
        } else {
            System.out.println(fibonacci(0, 1, n - 1));
        }
    }

    static int fibonacci(int n1, int n2, int count) {
        if (count == 1) {
            return n1 + n2;
        }
        return fibonacci(n2, n1 + n2, count - 1);
    }

}
