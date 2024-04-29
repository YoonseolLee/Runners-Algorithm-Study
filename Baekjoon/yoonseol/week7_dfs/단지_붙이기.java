package Baekjoon.yoonseol.week7_dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지_붙이기 {
    static int[][] map;
    static boolean[][] visited;
    static int N = 0;
    static int totalCount;
    static int attributeCount;
    static List<Integer> attributeCountContainer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine(); // 한 줄을 읽어서
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0'; // 각 문자를 숫자로 변환하여 저장
            }
        }

        totalCount = 0; // 총 집합 개수
        attributeCountContainer = new ArrayList<>(); // 요소 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 요소가 1이고, 방문하지 않았다면
                if (map[i][j] == 1 && visited[i][j] == false) {
                    // 요소 개수 초기화
                    attributeCount = 0;
                    dfs(i, j);
                    totalCount++;
                    attributeCountContainer.add(attributeCount);
                }
            }
        }

        Collections.sort(attributeCountContainer);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(totalCount + "\n");

        for (int i : attributeCountContainer) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int startX, int startY) {
        visited[startX][startY] = true; // 현재 위치 방문처리
        attributeCount++;

        // 상하좌우
        int[] X = {0, 0, -1, +1};
        int[] Y = {-1, +1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int x = startX + X[i];
            int y = startY + Y[i];

            // 1. 0보다 작거나 N 이상인 경우 건너뛴다.
            if (x < 0 || x >= N || y < 0 || y >= N) {
                continue;
            }

            // 2. 인접한 위치에 1이 있고, 아직 방문하지 않았다면
            if (map[x][y] == 1 && visited[x][y] == false) {
                dfs(x, y); // 재귀적으로 DFS 수행
            }
        }
    }
}

