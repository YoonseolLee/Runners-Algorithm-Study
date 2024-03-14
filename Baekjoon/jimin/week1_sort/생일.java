package Baekjoon.jimin.week1_sort;

import java.time.LocalDate;
import java.util.*;

/**
 * 백준 5635번 실버 5
 */
public class 생일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, LocalDate> birthdays = new HashMap<>();

        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            LocalDate birthday = LocalDate.of(year, month, day);

            birthdays.put(name, birthday);
        }

        /*
            Map을 값으로 정렬한 리스트 생성 - Map은 순서가 없기 때문
            entry: Map 자료구조에서 키(key)와 값(value)의 쌍을 나타내는 객체
         */
        List<Map.Entry<String, LocalDate>> sortedList = new ArrayList<>(birthdays.entrySet());


        /*
            Collections.sort() 메서드는 기본적으로 정렬할 때  natural order를 사용.
            그러나 현재 sortedList는 map.entry의 리스트로 기본적으로 정의된? 정렬 방식이 없음
            따라서 Comparator 인터페이스를 구현해서 정렬 기준을 명시적으로 지정
         */
        Collections.sort(sortedList, new Comparator<Map.Entry<String, LocalDate>>() {
            @Override
            public int compare(Map.Entry<String, LocalDate> o1, Map.Entry<String, LocalDate> o2) {
                //map.entry의 value를 기준으로 정렬
                //날짜를 오름차순으로 정렬
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println(sortedList.get(sortedList.size() - 1).getKey()); //가장 나이가 적은 사람
        System.out.println(sortedList.get(0).getKey()); //가장 나이가 많은 사람
    }
}
