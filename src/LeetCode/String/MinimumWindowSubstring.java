import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        int left = 0;
        int right = 0;
        int start = 0;
        int minValue = Integer.MAX_VALUE;
        int count = 0;
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (right = 0; right < s.length(); right++) {
            if (tMap.containsKey(s.charAt(right))) {
                tMap.put(s.charAt(right), tMap.get(s.charAt(right)) - 1);
                if (tMap.get(s.charAt(right)) >= 0) {
                    count++;
                }
            }

            while (count == t.length()) {
                if (right - left + 1 < minValue) {
                    minValue = right - left + 1;
                    start = left;
                }

                if (tMap.containsKey(s.charAt(left))) {
                    tMap.put(s.charAt(left), tMap.get(s.charAt(left)) + 1);
                    if (tMap.get(s.charAt(left)) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return minValue == Integer.MAX_VALUE ? "" : s.substring(start, start + minValue);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "AAAAAABC";
        String t = "ABC";
        String minWindow = solution.minWindow(s, t);
        System.out.println("Min Window Substring: " + minWindow);
    }
}
