package LeetCode.String;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class E_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();

        Arrays.stream(strs)
                .forEach(str -> {
                    char[] charArray = str.toCharArray();
                    Arrays.sort(charArray);
                    String sortedStr = new String(charArray);

                    hashMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
                });

        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        E_GroupAnagrams solution = new E_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);

        result.forEach(group -> System.out.println(group));
    }
}
