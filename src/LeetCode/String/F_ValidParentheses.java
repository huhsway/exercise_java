package LeetCode.String;

import java.util.*;

// https://leetcode.com/problems/valid-parentheses/ 
public class F_ValidParentheses {
    public boolean isValid(String s) {
        // Optional: Check if the length of the string is even
        // if (s.length() % 2 != 0) return false;

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // 존재하는 여는 괄호이면 넣고
            if (pairs.containsKey(current)) {
                stack.push(current);
                continue;
            }

            // stack이 안비었고 닫는 괄호가 stack 맨 위에 있는 값과 같다면 stack 맨 위에 비우기
            if (!stack.isEmpty() && pairs.get(stack.peek()) == current) {
                stack.pop();
                continue;
            }

            // 해당하는 경우가 아니라면 return false;
            return false;
        }

        // for문 다 돌고 stack이 비어있으면 true 반환 아니면 false 반환
        return stack.isEmpty();
    }
}
