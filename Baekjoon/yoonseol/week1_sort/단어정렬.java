package Baekjoon.yoonseol.week1_sort;

import java.io.*;
import java.util.*;

class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int repetition = Integer.parseInt(br.readLine());

        String[] array = new String[repetition];
        for (int i = 0; i < repetition; i++) {
            String input = br.readLine();
            array[i] = input;
        }

        String[] uniqueArr = sort(array);

        for (String str : uniqueArr) {
            System.out.println(str);
        }
    }


    static String[] sort(String[] array) {
        // 길이가 짧은 것 부터, 길이가 같으면 사전 순으로 정렬
        Arrays.sort(array, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // 중복 제거
        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(array));
        String[] uniqueArr = set.toArray(new String[0]);

        return uniqueArr;
    }
}