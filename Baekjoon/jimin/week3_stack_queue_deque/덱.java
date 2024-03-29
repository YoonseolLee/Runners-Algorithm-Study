package Baekjoon.jimin.week3_stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            int X = 0;
            switch (command) {
                case "push_front":
                    X = Integer.parseInt(st.nextToken());
                    deque.offerFirst(X);
                    break;

                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    deque.offer(X);
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.poll());
                    }
                    sb.append("\n");
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.pollLast());
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(deque.size() + "\n");
                    break;

                case "empty":
                    if (deque.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case "front":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peek());
                    }
                    sb.append("\n");
                    break;

                case "back":
                    if (deque.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
