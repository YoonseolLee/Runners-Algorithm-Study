package Baekjoon.yoonseol.week7_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 유기농배추 {

    static int[][] ground; // 배추밭을 나타내는 2차원 배열
    static boolean[][] check; // 방문 여부를 확인하는 2차원 배열
    static int weight; // 배추밭의 가로 길이
    static int height; // 배추밭의 세로 길이

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
            StringTokenizer st;
            for (int i=0; i < T; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                weight = Integer.parseInt(st.nextToken());
                height = Integer.parseInt(st.nextToken());
                ground = new int[weight][height];
                check = new boolean[weight][height];

                int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 수
                for (int j=0; j < K; j++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    int x =  Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    ground[x][y] = 1; // 배추가 심어진 위치에 1을 표시
                }

                int count = 0; // 필요한 지렁이의 개수

                for (int j=0; j < weight; j++) {
                    for (int k =0; k < height; k++) {
                        // 배추가 있고 방문하지 않은 위치라면
                        if (ground[j][k] == 1 && !check[j][k]) {
                            dfs(j,k); // 해당 위치에서 DFS 수행
                            count++; // DFS를 수행하면 연결된 모든 배추가 방문 처리되므로 지렁이 한 마리 추가
                        }
                    }
                }
                System.out.println(count); // 필요한 지렁이의 개수 출력
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int startX, int startY) {
        check[startX][startY] = true; // 현재 위치 방문 처리

        // 상, 하, 좌, 우 이동을 위한 배열
        int[] X = {0,0,-1,+1};
        int[] Y = {-1, +1, 0, 0};

        for (int i =0 ; i < 4; i++) {
            int x = startX + X[i];
            int y = startY + Y[i];

            // 배추밭을 벗어나는 경우 건너뛰기
            if ( x < 0 || x >= weight || y < 0 || y >= height) {
                continue;
            }

            // 인접한 위치에 배추가 있고 아직 방문하지 않았다면
            if (ground[x][y] == 1 && !check[x][y]) {
                dfs(x,y); // 재귀적으로 DFS 수행
            }
        }
    }
}

