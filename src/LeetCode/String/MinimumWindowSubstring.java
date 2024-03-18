package LeetCode.String;

import java.util.*;
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int minValue = Integer.MAX_VALUE;
        int count = tLen;
        int start = 0;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (right < sLen) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) > 0) {
                    count--;
                }
            }
            right++;

            while (count == 0) {
                if (right - left < minValue) {
                    minValue = right - left;
                    start = left;
                }

                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return minValue == Integer.MAX_VALUE ? "" : s.substring(start, start + minValue);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "AAAAAABC";
        String t = "ABC";
        String minWindow = solution.minWindow(s, t);
        System.out.println("Min Window Substring: " + minWindow);
    }
}
