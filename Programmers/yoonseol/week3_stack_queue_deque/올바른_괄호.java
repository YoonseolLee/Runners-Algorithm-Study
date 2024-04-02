package Programmers.yoonseol.week3_stack_queue_deque;

import java.util.Stack;

class 올바른_괄호 {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }

            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        /**
         * 스택이 비어있으면 모든 열린 괄호가 적절히 닫힌 괄호와 짝을 이뤘다는 뜻
         * 스택이 비어있지 않으면, 모든 괄호가 적절히 닫히지 않았다는 뜻
         */
        return stack.isEmpty();
    }
}
