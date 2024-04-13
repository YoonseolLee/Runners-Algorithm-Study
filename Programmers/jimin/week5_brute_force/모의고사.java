package Programmers.jimin.week5_brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        int[] count = {0,0,0};

        for(int i=0;i<answers.length;i++){
            if(person1[i % 5] == answers[i]) count[0]++;
        }

        for(int i=0;i<answers.length;i++){
            if(person2[i% 8] == answers[i ]) count[1]++;
        }

        for(int i=0;i<answers.length;i++){
            if(person3[i % 10] == answers[i]) count[2]++;
        }

        int[] bigCount = count.clone();
        Arrays.sort(bigCount);
        int big = bigCount[2];

        List<Integer> answer1 = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(big == count[i]) answer1.add(i+1);
        }

        int[] answer = new int[answer1.size()];
        for(int i=0;i<answer1.size();i++){
            answer[i] = answer1.get(i);
        }
        return answer;
    }
}
