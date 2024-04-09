package LeetCode.String;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int maxLength = 0;
        int maxCount = 0;
        int left = 0;
        int right = 0;

        for (right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxCount = Math.max(maxCount, count.get(s.charAt(right)));

            if (right - left + 1 - maxCount > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 2;
        int result = solution.characterReplacement(s, k);
        System.out.println("Maximum length of substring after replacements: " + result);
    }
}
