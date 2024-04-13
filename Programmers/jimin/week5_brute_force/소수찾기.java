package Programmers.jimin.week5_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소수찾기 {
    static String[] part;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        part = numbers.split("");

        for (String p : part) {
            function(p);
        }

        answer = set.size();
        return answer;
    }

    private static void function(String number) {
        int intNumber = Integer.parseInt(number);

        if (isPrime(intNumber)) set.add(intNumber);
        for (int i = 0; i < part.length - number.length(); i++) {
            String next = findNext(number, i);
            if (next.equals("-1")) return;
            else function(number + findNext(number, i));
        }
    }

    private static String findNext(String number, int i) {
        for (String p : part) {
            int index = number.indexOf(p);

            if (index == -1) {
                if (i-- == 0) return p;
            } else if (index != -1) number = number.substring(0, index) + number.substring(index + 1);

        }
        return "-1";
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
