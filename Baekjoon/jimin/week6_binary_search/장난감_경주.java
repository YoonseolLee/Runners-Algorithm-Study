package Baekjoon.jimin.week6_binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장난감_경주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //참가자 수
            int X = Integer.parseInt(st.nextToken()); //트랙의 길이
            int Y = Integer.parseInt(st.nextToken()); //부스터 속터 한계치

            st = new StringTokenizer(br.readLine());
            int[] v = new int[N];
            int maxSpeed = 0;
            for (int j = 0; j < N; j++) {
                v[j] = Integer.parseInt(st.nextToken());
                if (maxSpeed < v[j]) {
                    maxSpeed = v[j];
                }
            }

            //부스터 쓰지 않아도 단독 우승인 경우
            boolean isWinner = false;
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (v[j] == maxSpeed) {
                    if (j == N - 1 && count == 0) {
                        isWinner = true;
                        sb.append(0).append("\n");
                    }
                    count++;
                }
            }
            if (isWinner) continue;

            //부스터로 갈 수 있는 최소 거리, 최대 거리
            int start = 0;
            int end = Y;
            double threshold = X * 1.0 / maxSpeed; //부스터 안썼을 때 1등의 시간
            double booster = (X - end) * 1.0 / v[N - 1] + 1; //부스터 최대한 사용했을 때 나오는 최소 시간

            //부스터를 최대로 써도 단독 우승 불가한 경우
            if (threshold <= booster) {
                sb.append(-1).append("\n");
                continue;
            }

            int middle = -2;

            //while문에 같을 때까지 -> if 조건 중에 booster, threshold가 같으면 start 값 증가 -> 답은 start
            while (start <= end) {
                middle = (start + end) / 2;
                booster = (X - middle) * 1.0 / v[N - 1] + 1;
                if (booster >= threshold) start = middle + 1; // 부스터 차가 더 느림 -> 속력 업 -> 거리 늘려야함
                else if (booster < threshold) end = middle - 1; //부스터 차가 더 빠르거나 같아 -> 거리 줄여야함
            }
            sb.append(start).append("\n");

        }
        System.out.println(sb);
    }
}
