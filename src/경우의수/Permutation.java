package 경우의수;

import java.util.*;
import java.util.stream.Collectors;

class Permutation {
    public static void permutation(int n, int r, int depth, int[] perArr, boolean[] perCheck, int[] arr, List<List<Integer>> result) {
        if (depth == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < perArr.length; i++) {
                temp.add(perArr[i]);
            }
//            List<Integer> temp = Arrays.stream(perArr).boxed().collect(Collectors.toCollection(ArrayList::new));
            result.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!perCheck[i]) {
                perArr[depth] = arr[i];
                perCheck[i] = true;
                permutation(n, r, depth + 1, perArr, perCheck, arr, result);
                perCheck[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int[] perArr = new int[arr.length];
        boolean[] perCheck = new boolean[arr.length];
        List<List<Integer>> result = new ArrayList<>();

        permutation(arr.length, arr.length, 0, perArr, perCheck, arr, result);

        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
}