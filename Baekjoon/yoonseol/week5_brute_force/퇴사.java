package Baekjoon.yoonseol.week5_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    static int N;
    static int[][] schedule;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N까지만 일 함
        schedule = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 상담 소요시간
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 금액
        }

        result = 0;
        // 0일부터 시작함

        dfs(0,0);
        System.out.println(result);

    }

    /**
     * 1. 기저 조건(Base Case) 체크: 만약 현재 날짜 idx가 전체 기간 N을 넘어서면,
     * 현재까지의 수익 pay와 이전까지의 최대 수익 result를 비교하여 더 큰 값을 result에 저장하고 함수를 종료한다.
     * 이는 더 이상 상담을 진행할 수 없음을 의미한다.
     *
     * 2. 상담 진행 가능 여부 판단: 현재 날짜 idx에 시작한 상담이 기간 내에 끝날 수 있는지를 판단한다.
     * 상담을 끝마칠 수 있다면(idx + schedule[idx][0] <= N), 해당 상담을 진행하고(dfs(idx + schedule[idx][0], pay + schedule[idx][1])),
     * 다음 상담 가능 날짜로 이동하며 지금까지의 수익에 현재 상담의 수익을 추가한다.
     *
     * 3. 상담을 진행하지 않는 경우: 상담이 기간 내에 끝날 수 없거나 상담을 진행하지 않기로 결정한 경우, 현재 날짜 idx에서 1일만 증가시키고(dfs(idx + 1, pay)),
     * 수익은 그대로 유지한 채로 다음 날짜로 넘어간다. 이는 상담을 건너뛰고 다음 기회를 탐색하는 경우에 해당한다.
     */

    static void dfs(int idx, int pay) {
        if (idx >= N) {
            result = Math.max(pay, result);
            return;
        }

        if (idx + schedule[idx][0] <= N) {
            dfs(idx + schedule[idx][0], pay + schedule[idx][1]);
        } else {
            dfs(idx + schedule[idx][0], pay);
        }

        dfs(idx + 1, pay);
    }
}
