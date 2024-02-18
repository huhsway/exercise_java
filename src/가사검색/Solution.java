package 가사검색;

import java.util.*;

class Solution {

    public int lowerBound(List<String> arr, String target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid).compareTo(target) >= 0) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    public int upperBound(List<String> arr, String target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid).compareTo(target) > 0) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    public int countByRange(List<String> arr, String leftValue, String rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.size());
        int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
        return rightIndex - leftIndex;
    }

    public int[] solution(String[] words, String[] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<String>> arr = new ArrayList<>(10001);
        List<List<String>> reversedArr = new ArrayList<>(10001);

        for (int i = 0; i <= 10000; i++) {
            arr.add(new ArrayList<>());
            reversedArr.add(new ArrayList<>());
        }

        for (String word : words) {
            int len = word.length();
            arr.get(len).add(word);
            reversedArr.get(len).add(new StringBuilder(word).reverse().toString());
        }

        for (int i = 0; i <= 10000; i++) {
            Collections.sort(arr.get(i));
            Collections.sort(reversedArr.get(i));
        }

        for (String query : queries) {
            int result = 0;
            int len = query.length();

            if (query.charAt(0) != '?') {
                result = countByRange(arr.get(len), query.replaceAll("\\?", "a"), query.replaceAll("\\?", "z"));
            } else {
                query = new StringBuilder(query).reverse().toString();
                result = countByRange(reversedArr.get(len), query.replaceAll("\\?", "a"), query.replaceAll("\\?", "z"));
            }

            answer.add(result);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(words, queries)));
    }
}
