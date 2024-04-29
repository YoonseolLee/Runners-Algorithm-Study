package Programmers.yoonseol.week7_dfs;

public class 게임_맵_최단거리 {

    /**
     * DFS는 효율설 검사 탈락 ..
     * 추후에 BFS로 풀어볼 예정
     */
    // 4방향으로 이동할 때 사용되는 상대 좌표 값
    int[] x_list={0,0,1,-1};
    int[] y_list={1,-1,0,0};

    // 미로 맵에서 각 위치를 방문했는지 여부를 기록하는 배열
    int[][] visited;

    // 최단 경로의 길이를 저장하는 변수 (초기값: -1)
    int min_cnt = -1;

    public int solution(int[][] maps) {
        // visited 배열 초기화 (미로 맵의 크기와 동일한 크기로 초기화)
        visited = new int[maps.length][maps[0].length];

        // DFS 메서드 호출 (출발점: (0, 0), 현재 경로의 길이: 1)
        dfs(0, 0, maps, visited, 1);

        // 최단 경로의 길이 반환
        return min_cnt;
    }

    public int dfs(int x, int y, int[][] maps, int[][] visited, int cnt) {
        // 미로 맵의 높이와 너비
        int height = maps.length;
        int width = maps[0].length;

        // 현재 위치가 도착점인 경우
        if (x == height - 1 && y == width - 1) {
            // 최단 경로의 길이가 아직 저장되지 않았다면, 현재 경로의 길이를 저장
            if (min_cnt == -1) {
                min_cnt = cnt;
                return 0;
            }
            // 이미 최단 경로의 길이가 저장되어 있고, 현재 경로의 길이가 더 작다면 업데이트
            else if (min_cnt > cnt) {
                min_cnt = cnt;
                return 0;
            }
        }

        // 다음 위치의 좌표를 저장할 임시 변수
        int tempx = x;
        int tempy = y;

        // 4방향으로 탐색
        for (int i = 0; i < 4; i++) {
            // 다음 위치의 좌표 계산
            tempx = x + x_list[i];
            tempy = y + y_list[i];

            // 다음 위치의 좌표가 미로 맵의 범위 내에 있는 경우
            if ((tempx >= 0 && tempx < height) && (tempy >= 0 && tempy < width)) {
                // 다음 위치가 길(값이 1)이고, 아직 방문하지 않은 곳이라면
                if (maps[tempx][tempy] == 1 && visited[tempx][tempy] == 0) {
                    // 방문 표시
                    visited[tempx][tempy] = 1;
                    // 다음 위치로 재귀 호출 (경로의 길이 1 증가)
                    dfs(tempx, tempy, maps, visited, cnt + 1);
                    // 탐색 완료 후 방문 표시 제거
                    visited[tempx][tempy] = 0;
                }
            }
        }
        // 최단 경로의 길이 반환
        return min_cnt;
    }
}
