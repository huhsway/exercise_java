package LeetCode.String;

import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxCharCount = 0;
        Map<Character, Integer> visited = new HashMap<>();

        while (right < s.length()) { // 초깃값 left, right = 0
            visited.put(s.charAt(right), visited.getOrDefault(s.charAt(right), 0) + 1);
            maxCharCount = Math.max(maxCharCount, visited.get(s.charAt(right)));

            if (right - left + 1 - maxCharCount > k) {
                visited.put(s.charAt(left), visited.get(s.charAt(left)) - 1);
                left++;
            }

            right++;
        }

        return right - left;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 2;
        int result = solution.characterReplacement(s, k);
        System.out.println("Maximum length of substring after replacements: " + result);
    }
}
