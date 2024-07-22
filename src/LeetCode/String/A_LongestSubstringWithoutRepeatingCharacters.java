package LeetCode.String;

import java.util.Arrays;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/ 
public class A_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String check = "";
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (check.contains(String.valueOf(s.charAt(i)))) {
                check = check.substring(check.indexOf(s.charAt(i)) + 1);
            }

            check += s.charAt(i);
            result[i] = check.length();
        }

        return Arrays.stream(result)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        A_LongestSubstringWithoutRepeatingCharacters solution = new A_LongestSubstringWithoutRepeatingCharacters();
        String input = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring: " + length);
    }
}
