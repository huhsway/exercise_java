package LeetCode.String;

public class LongestPalindromeSubstring {
    public boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean isPalindrome = isPalindrome(s);
        if (isPalindrome)
            return s;
        int maxLength = 1;
        int start = 0;
        int left, right;
        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i + 1;

            while (right < n && s.charAt(right) == s.charAt(i)) // increment 'right'
                right++;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) // decrement 'left'
                left--;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            int length = right - left - 1;
            if (maxLength < length) {
                maxLength = length;
                start = left + 1;
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();
        String s = "babad";
        String result = solution.longestPalindrome(s);
        System.out.println("Longest palindrome substring is: " + result);
    }
}
