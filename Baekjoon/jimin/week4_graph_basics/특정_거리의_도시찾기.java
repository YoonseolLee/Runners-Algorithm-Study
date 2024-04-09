package Baekjoon.jimin.week4_graph_basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정_거리의_도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] nodes = new ArrayList[N + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes[A].add(B);
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        deque.offer(X);
        distance[X] = 0;
        List<Integer> answers = new ArrayList<>();
        while (!deque.isEmpty()) {
            int current = deque.poll();
            if (distance[current] > K) break;
            if (distance[current] == K) answers.add(current);

            for (int next : nodes[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    deque.offer(next);
                }
            }
        }

        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        for (int answer : answers) {
            sb.append(answer).append("\n");
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}
