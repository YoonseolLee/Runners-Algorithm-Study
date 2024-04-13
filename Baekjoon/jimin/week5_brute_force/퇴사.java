package Baekjoon.jimin.week5_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] time = new int[N + 1];
        int[] pay = new int[N + 1];
        int[] dp = new int[N + 2]; //각 날짜별로 얻을 수 있는 최대 이익

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            // i번째 날에 상담을 했을 때 다시 새로운 상담을 할 수 있는 날짜
            int next = i + time[i];

            // 상담이 퇴사 전에 끝날 경우
            // 상담을 하는 경우와 하지 않는 경우 중 최대 이익 선택
            if (next <= N + 1) dp[i] = Math.max(pay[i] + dp[next], dp[i + 1]);

            // 퇴사일 이후에 끝나는 상담은 고려하지 않음
            else dp[i] = dp[i + 1];
        }

        System.out.println(dp[1]);

    }
}
