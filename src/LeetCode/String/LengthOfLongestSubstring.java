public class LengthOfLongestSubstring {
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

        int maxLength = 0;
        for (int len : result) {
            if (len > maxLength) {
                maxLength = len;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String input = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(input);
        System.out.println(length);
    }
}
