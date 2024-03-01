package 경우의수;

import java.util.*;
import java.util.stream.Collectors;

// 거의 안씀
public class RepeatPermutation {

    public static void main(String[] args) {
        int n = 3;
        int r = 2;
        int[] arr = {3, 6, 9};
        List<List<Integer>> result = getRepeatPermutation(n, r, arr);

        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static List<List<Integer>> getRepeatPermutation(int n, int r, int[] arr) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        dfs(n, r, arr, temp, answer, 0);
        return answer;
    }

    private static void dfs(int n, int r, int[] arr, List<Integer> temp, List<List<Integer>> answer, int depth) {
        if (depth == r) {
            answer.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < n; i++) {
                temp.add(arr[i]);
                dfs(n, r, arr, temp, answer, depth + 1);
                temp.remove(temp.size() - 1); // backtrack
            }
        }
    }

//    public static void repeatPermutation(int n, int r, int depth, int[] perArr, int[] arr, List<List<Integer>> result) {
//        if (depth == r) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            for (int i : perArr) {
//                temp.add(i);
//            }
////            ArrayList<Integer> temp = Arrays.stream(perArr).boxed().collect(Collectors.toCollection(ArrayList::new));
//            result.add(temp);
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            perArr[depth] = arr[i];
//            repeatPermutation(n, r, depth + 1, perArr, arr, result);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4};
//
//        int[] perArr = new int[arr.length];
//        List<List<Integer>> result = new ArrayList<>();
//
//        repeatPermutation(arr.length, arr.length, 0, perArr, arr, result);
//
//        for (List<Integer> integers : result) {
//            System.out.println(integers);
//        }
//    }

}
