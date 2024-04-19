
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수찾기 {

    public static int[] array;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 정렬한다.
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {

            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력한다.
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    /**
     * key = 5이고, 배열이 {1,2,3,4,5} 일 때의 예시
     *
     * 1. 초기 설정: lo = 0, hi = 4 (배열의 처음과 끝 인덱스).
     *    첫 번째 중간지점(mid) 계산: mid = (0 + 4) / 2 = 2.
     *    배열의 중간 값은 array[2] = 3
     *    5는 3보다 크므로, lo를 mid + 1인 3으로 조정한다.
     *
     * 2. 새로운 범위에서 중간지점 계산: lo = 3, hi = 4.
     *    mid = (3 + 4) / 2 = 3 (!!자바에서는 소수점 이하를 버림!!).
     *    배열의 중간 값은 array[3] = 4
     *    5는 4보다 크므로, lo를 mid + 1인 4로 조정한다.
     *
     * 3. 이제 lo = 4, hi = 4다. 범위가 좁혀졌고 lo와 hi가 같다.
     *    중간지점 계산: mid = (4 + 4) / 2 = 4.
     *    배열의 중간 값은 array[4] = 5이며, 이는 찾고자 하는 key와 일치한다.
     *    따라서, 찾고자 하는 값의 인덱스인 4를 반환한다.
     */

    public static int binarySearch(int key) {
        int lo = 0;
        int hi = array.length - 1;

        // lo가 hi보다 커지기 전까지 반복한다.
        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (key < array[mid]) {
                hi = mid - 1;
            }

            if (key > array[mid]) {
                lo = mid + 1;
            }

            if (key == array[mid]) {
                return mid;
            }
        }

        // 찾고자 하는 값이 없는 경우
        return -1;
    }
}