package Programmers.yoonseol.week1_sort;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

class K번째_수 {
    public int[] solution(int[] array, int[][] commands) throws IOException {
        int commandsLength = commands.length;
        int[] result = new int[commandsLength];

        for (int i = 0; i < commandsLength; i++) {
            int[] command = commands[i];
            int start = command[0] - 1;
            int end = command[1];
            int extract = command[2] - 1;
            int[] tempArray = new int[end - start];

            for (int j = start; j < end; j++) {
                tempArray[j - start] = array[j];
            }

            selectionSort(tempArray);

            result[i] = tempArray[extract];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < result.length; i++) {
            bw.write(Arrays.toString(result));
            if (i < result.length - 1) {
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();

        return result;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
