package Programmers.yoonseol.week5_brute_force;

import java.util.*;

class 소수찾기 {
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();

        // 모든 숫자 조합 생성
        permutation("", numbers, numberSet);

        // 소수 판별
        int count = 0;
        for (int number : numberSet) {
            if (isPrime(number)) {
                count++;
            }
        }

        return count;
    }

    // 순열을 이용한 숫자 조합 생성 함수
    private void permutation(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        if (!prefix.equals("")) {
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    // 소수 판별 함수
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

