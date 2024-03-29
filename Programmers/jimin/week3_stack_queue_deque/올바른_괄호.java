package Programmers.jimin.week3_stack_queue_deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()(((()))"));
    }

    static boolean solution(String s) {
        boolean answer = true;
        int length = s.length();

        Deque<Character> deque = new ArrayDeque<>();
        for(int i=0 ; i<length ; i++){

            if(s.charAt(i) == '('){
                deque.offerLast('(');
            }
            //입력된 글자가 ')'인 경우
            else if(deque.pollLast() == null){
                answer = false;
            }
        }

        if(!deque.isEmpty()){
            answer = false;
        }

        return answer;

    }
}
