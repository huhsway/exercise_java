package LeetCode.String;

import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxCharCount = 0;
        Map<Character, Integer> visited = new HashMap<>();

        while (right < s.length()) {
            char charAtRight = s.charAt(right);
            visited.put(charAtRight, visited.getOrDefault(charAtRight, 0) + 1);
            maxCharCount = Math.max(maxCharCount, visited.get(charAtRight));

            if (right - left + 1 - maxCharCount > k) {
                char charAtLeft = s.charAt(left);
                visited.put(charAtLeft, visited.get(charAtLeft) - 1);
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
