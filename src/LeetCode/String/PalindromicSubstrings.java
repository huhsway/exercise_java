package LeetCode.String;

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += getPalCount(s, i, i);    // odd length strings
            count += getPalCount(s, i, i+1);  // even length strings
        }

        return count;
    }

    public static int getPalCount(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        String input = "ababa";
        int result = countSubstrings(input);
        System.out.println("Number of palindrome substrings: " + result);
    }
}
