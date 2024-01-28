package LeetCode.String;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {
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
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String input = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of longest substring: " + length);
    }
}
