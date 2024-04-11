package Programmers.yoonseol.week5_brute_force;

import java.util.*;

class 모의고사 {
    public List<Integer> solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};

        // 점수 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) {
                score[0]++;
            }
            if (answers[i] == second[i % 8]) {
                score[1]++;
            }
            if (answers[i] == third[i % 10]) {
                score[2]++;
            }
        }

        // 최대 점수 구하기
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        // 최대 점수를 가진 수포자 리스트 생성
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (max == score[i]) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}
