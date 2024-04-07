package LeetCode.String;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> count = new HashMap<>(); // 문자와 해당 문자의 개수를 저장할 맵
        int maxCount = 0; // 최대 반복 문자 개수
        int maxLength = 0; // 최대 부분 문자열 길이
        int left = 0; // 윈도우의 왼쪽 인덱스

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1); // 해당 문자의 개수 증가
            maxCount = Math.max(maxCount, count.get(c)); // 최대 반복 문자 개수 갱신

            // 윈도우 내의 교체 가능한 문자 개수 계산
            int replaceCount = right - left + 1 - maxCount;
            if (replaceCount > k) {
                // 윈도우 내의 문자 개수 초과 시, 윈도우의 왼쪽을 이동하여 조절
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1); // 윈도우에서 가장 왼쪽에 있는 문자 개수 감소
                left++; // 윈도우의 왼쪽 이동
            }

            // 현재 부분 문자열 길이 갱신
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
