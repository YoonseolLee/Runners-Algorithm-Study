package Programmers.jimin.week7_dfs;

/**
 * 시간 초과
 */
public class 게임맵_최단거리 {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int[][] distance;
    int count = 0;
    int answer = Integer.MAX_VALUE;
    int n, m;

    private void dfs(int x, int y, int[][] map) {
        if (x == n - 1 && y == m - 1) {
            answer = Math.min(answer, distance[x][y]);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                if (map[cx][cy] == 1 && distance[cx][cy] == 0) {
                    distance[cx][cy] = distance[x][y] + 1;
                    dfs(cx, cy, map);
                    distance[cx][cy] = 0;
                }
            }
        }
    }

    public int solution(int[][] maps) {
        n = maps.length; //행
        m = maps[0].length; //열
        distance = new int[n][m];

        distance[0][0] = 1;
        dfs(0, 0, maps);
        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}; //11
        //int[][] maps = {{1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}}; //9
        int result = new 게임맵_최단거리().solution(maps);
        System.out.println(result);
    }
}
