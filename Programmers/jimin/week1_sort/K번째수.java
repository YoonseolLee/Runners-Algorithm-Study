package Programmers.jimin.week1_sort;

import java.util.Arrays;

/**
 * 프로그래머스 K번째수 level 1
 */
public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {

        int length = commands.length;
        int[] answer = new int[length];

        for (int m = 0; m < length; m++) {
            int[] command = commands[m];

            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] sliceArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sliceArray);
            answer[m] = sliceArray[k - 1];

        }

        return answer;
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        K번째수 solutionInstance = new K번째수(); // 클래스 인스턴스 생성
        int[] result = solutionInstance.solution(array, commands);

        for (int num : result) {
            System.out.println(num);
        }
    }

}
