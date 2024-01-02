package 가사검색;

import java.util.*;

class Solution {

    public int lowerBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public int upperBound(ArrayList<String> arr, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.size());
        int leftIndex = lowerBound(arr, leftValue, 0, arr.size());
        return rightIndex - leftIndex;
    }

    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<String>> arr = new ArrayList<>(10001);
        ArrayList<ArrayList<String>> reversedArr = new ArrayList<>(10001);

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
            int res = 0;
            int len = query.length();

            if (query.charAt(0) != '?') {
                res = countByRange(arr.get(len), query.replaceAll("\\?", "a"), query.replaceAll("\\?", "z"));
            } else {
                query = new StringBuilder(query).reverse().toString();
                res = countByRange(reversedArr.get(len), query.replaceAll("\\?", "a"), query.replaceAll("\\?", "z"));
            }

            ans.add(res);
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(words, queries)));
    }
}
