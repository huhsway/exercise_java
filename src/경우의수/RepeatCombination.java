package 경우의수;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatCombination {

    public static void main(String[] args) {
        int n = 3;
        int r = 2;
        int[] arr = {3, 6, 9};
        List<List<Integer>> result = getRepeatCombination(n, r, arr);

        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }

    public static List<List<Integer>> getRepeatCombination(int n, int r, int[] arr) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        dfs(n, r, arr,temp, answer,0, 0);
        return answer;
    }

    private static void dfs(int n, int m, int[] arr, List<Integer> temp, List<List<Integer>> answer, int depth, int start) {
        if (depth == m) {
            answer.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < n; i++) {
                temp.add(arr[i]);
                dfs(n, m, arr, temp, answer, depth + 1, i);
                temp.remove(temp.size() - 1); // backtrack
            }
        }
    }

//    public static void repeatCombination(int n, int r, int depth, int[] comArr, int start, int[] arr, List<List<Integer>> result) {
//        if (depth == r) {
//            List<Integer> temp = new ArrayList<>();
//            for (int i : comArr) {
//                temp.add(i);
//            }
////            List<Integer> temp = Arrays.stream(comArr).boxed().collect(Collectors.toCollection(ArrayList::new));
//            result.add(temp);
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            comArr[depth] = arr[i];
//            repeatCombination(n, r, depth + 1, comArr, i, arr, result);
//            comArr[depth] = 0;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//
//        int[] comArr = new int[2];
//        List<List<Integer>> result = new ArrayList<>();
//        repeatCombination(arr.length, 2, 0, comArr, 0, arr, result);
//
//        for (List<Integer> integers : result) {
//            System.out.println(integers);
//        }
//    }
}
