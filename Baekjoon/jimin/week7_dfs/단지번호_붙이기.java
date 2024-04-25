package Baekjoon.jimin.week7_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호_붙이기 {
    static int N, count;
    static int[] directionX = {0, 0, 1, -1};
    static int[] directionY = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.valueOf(str[j]);
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        sb.append(answer.size()).append("\n");
        Collections.sort(answer);
        for (int a : answer) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int row, int col) {
        count++;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int currentX = directionX[i] + row;
            int currentY = directionY[i] + col;

            if (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
                if (!visited[currentX][currentY] && map[currentX][currentY] == 1) {
                    dfs(currentX, currentY);
                }
            }
        }
    }
}
