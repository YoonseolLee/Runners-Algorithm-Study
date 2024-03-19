package Baekjoon.jimin.week1_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1181번 실버 5
 */
public class 단어_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = new ArrayList<>();
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            words.add(br.readLine());
        }

        //중복 제거
        Set<String> hashSet = new HashSet<>(words);
        List<String> distinctWords = new ArrayList<>(hashSet);

        //글자 길이 순으로, 같다면 알파벳 순으로
        Collections.sort(distinctWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer length1 = o1.length();
                Integer length2 = o2.length();

                int lengthComparison = length1.compareTo(length2);
                if (lengthComparison == 0) {
                    return o1.compareTo(o2);
                }

                return lengthComparison;
            }
        });

        for (String word : distinctWords) {
            System.out.println(word);
        }
    }
}
