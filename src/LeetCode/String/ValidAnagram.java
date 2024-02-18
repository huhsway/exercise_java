package LeetCode.String;

import java.util.*;
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 만약 출력 하려면
        // sMap.forEach((key, value) -> System.out.println(key + ": " + value));

        return Arrays.equals(sMap.entrySet().toArray(), tMap.entrySet().toArray());
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }

}
