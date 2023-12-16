package 경우의수;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatCombination {
    public static void repeatCombination(int n, int r, int depth, int[] comArr, int start, int[] arr, List<List<Integer>> result) {
        if (depth == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i : comArr) {
                temp.add(i);
            }
//            List<Integer> temp = Arrays.stream(comArr).boxed().collect(Collectors.toCollection(ArrayList::new));
            result.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            comArr[depth] = arr[i];
            repeatCombination(n, r, depth + 1, comArr, i, arr, result);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int[] comArr = new int[2];
        List<List<Integer>> result = new ArrayList<>();
        repeatCombination(arr.length, 2, 0, comArr, 0, arr, result);

        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}
