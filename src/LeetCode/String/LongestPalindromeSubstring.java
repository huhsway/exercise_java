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
        int low, high;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;

            while (high < n && s.charAt(high) == s.charAt(i)) // increment 'high'
                high++;

            while (low >= 0 && s.charAt(low) == s.charAt(i)) // decrement 'low'
                low--;

            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
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
