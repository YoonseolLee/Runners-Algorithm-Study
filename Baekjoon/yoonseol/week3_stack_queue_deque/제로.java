package Baekjoon.yoonseol.week3_stack_queue_deque;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repetition = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < repetition; i++) {
            int number = Integer.parseInt(br.readLine());
            function(list, number);
        }
        calc(list);
    }

    static void function(List<Integer> list, int number) {
        if (number == 0) {
            int size = list.size();
            list.remove(size - 1);
        } else {
            list.add(number);
        }
    }

    static void calc(List<Integer> list) throws IOException {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
