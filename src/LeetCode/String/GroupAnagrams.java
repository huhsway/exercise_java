package LeetCode.String;

import java.util.*;

public class GroupAnagrams {
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
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);

        result.forEach(group -> System.out.println(group));
    }
}
