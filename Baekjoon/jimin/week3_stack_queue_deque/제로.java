package Baekjoon.jimin.week3_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                stack.offer(input);
            } else {
                stack.pollLast();
            }
        }

        int sum = 0;
        for (int number : stack) {
            sum += number;
        }

        System.out.println(sum);
    }
}
