package LeetCode.String;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the clean string is a palindrome
        int left = 0;
        int right = cleanString.length() - 1;
        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test cases
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Example 1: " + solution.isPalindrome(s1)); // Output: true

        String s2 = "race a car";
        System.out.println("Example 2: " + solution.isPalindrome(s2)); // Output: false

        String s3 = " ";
        System.out.println("Example 3: " + solution.isPalindrome(s3)); // Output: true
    }
}
