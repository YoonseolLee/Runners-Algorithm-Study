package Baekjoon.yaejoon.week1_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어정렬 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            answer[i]=st;
        }

        for (int i = 0; i < n - 1; ) {
            if (answer[i].length() > answer[i + 1].length()) {
                String temp = answer[i];
                answer[i] = answer[i + 1];
                answer[i + 1] = temp;
                if(i!=0){i = i-1;}else{i=0;}
            } else if (answer[i].length() == answer[i + 1].length()) {
                String[] temp = new String[2];
                temp[0] = answer[i];
                temp[1] = answer[i + 1];
                Arrays.sort(temp);

                if(answer[i].equals(temp[0])){
                    i++;
                }else{
                    answer[i] = temp[0];
                    answer[i + 1] = temp[1];
                    if(i!=0){i = i-1;}else{i=0;}
                }
            } else {
                i++;
            }
        }
        System.out.println(answer[0]);
        for (int i = 1; i < answer.length; i++) {
            if (!answer[i].equals(answer[i - 1])) {
                System.out.println(answer[i]);
            }
        }
    }
    public static void main (String[]args) throws Exception {
        new 단어정렬().solution();
    }

}