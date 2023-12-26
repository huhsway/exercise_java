package 경우의수;

import java.util.*;
import java.util.stream.Collectors;

class Combination {
    public static void combination(int n, int r, int depth, int[] comArr, int start, int[] arr, List<List<Integer>> result) {
        if (depth == r) {
            List<Integer> temp = new ArrayList<>();
            for (int i : comArr) {
                temp.add(i);
            }
            result.add(temp);
            //            List<Integer> temp = Arrays.stream(comArr).boxed().collect(Collectors.toCollection(ArrayList::new));
            return;
        }

        for (int i = start; i < n; i++) {
            comArr[depth] = arr[i];
            combination(n, r, depth + 1, comArr, i + 1, arr, result);
            comArr[depth] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int[] comArr = new int[5];
        List<List<Integer>> result = new ArrayList<>();
        combination(arr.length, 3, 0, comArr, 0, arr, result);

        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

//    // 만약에 길이가 1부터 담는다면
//    public static void combination(int n, int r, int depth, int[] comArr, int start, int[] arr, List<List<Integer>> result) {
//        if (depth == r) {
//            List<Integer> temp = new ArrayList<>();
//            for (int i : comArr) {
//                if (i != 0)
//                    temp.add(i);
//            }
//            List<Integer> temp = Arrays.stream(comArr)
//                    .filter(i -> i != 0)
//                    .boxed()
//                    .collect(Collectors.toCollection(ArrayList::new));
//            result.add(temp);
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            comArr[depth] = arr[i];
//            combination(n, r, depth + 1, comArr, i + 1, arr, result);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5};
//
//        int[] comArr = new int[5];
//        List<List<Integer>> result = new ArrayList<>();
//
//        for (int r = 1; r <= arr.length; r++)
//            combination(arr.length, r, 0, comArr, 0, arr, result);
//
//        for (List<Integer> integers : result) {
//            System.out.println(integers);
//        }
//
//    }
}