package LeetCode.String;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String str1) {
        String rev = new StringBuilder(str1).reverse().toString();
        return str1.equals(rev);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean isPalindrome = isPalindrome(s);

        if (isPalindrome)
            return s;

        int maxLength = 1, start = 0;
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

        return s.substring(start, maxLength + start);
    }
}
