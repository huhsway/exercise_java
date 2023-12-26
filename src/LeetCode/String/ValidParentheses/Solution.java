package LeetCode.String.ValidParentheses;

import java.util.*;
class Solution {
    public boolean isValid(String s) {
         if (s.length() % 2 != 0) return false;

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (pairs.containsKey(current)) {
                stack.push(current);
                continue;
            }

            if (!stack.isEmpty() && pairs.get(stack.peek()) == current) { // .get() 데이터 없으면 null 반환
                stack.pop();
                continue;
            }
            return false;
        }

        return stack.isEmpty();
    }
}