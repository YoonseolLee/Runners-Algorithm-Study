package Baekjoon.yoonseol.week3_stack_queue_deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repetition = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < repetition; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "push_front":
                    pushFront(deque, Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    pushBack(deque, Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    int num1 = popFront(deque);
                    sb.append(num1).append('\n');
                    break;

                case "pop_back":
                    int num2 = popBack(deque);
                    sb.append(num2).append('\n');
                    break;

                case "size":
                    int num3 = size(deque);
                    sb.append(num3).append('\n');
                    break;

                case "empty":
                    int num4 = empty(deque);
                    sb.append(num4).append('\n');
                    break;

                case "front":
                    int num5 = front(deque);
                    sb.append(num5).append('\n');
                    break;

                case "back":
                    int num6 = back(deque);
                    sb.append(num6).append('\n');
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void pushFront(Deque<Integer> deque, int input) {
        deque.offerFirst(input);
    }

    static void pushBack(Deque<Integer> deque, int input) {
        deque.offerLast(input);
    }

    static int popFront(Deque<Integer> deque) {
        Integer frontNum = deque.pollFirst();
        if (frontNum == null) {
            return -1;
        }
        return frontNum;
    }

    static int popBack(Deque<Integer> deque) {
        Integer lastNum = deque.pollLast();
        if (lastNum == null) {
            return -1;
        }
        return lastNum;
    }


    static int size(Deque<Integer> deque) {
        int size = deque.size();
        return size;
    }

    static int empty(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    static int front(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return -1;
        } else {
            return deque.peekFirst();
        }
    }

    static int back(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return -1;
        } else {
            return deque.peekLast();
        }
    }
}


