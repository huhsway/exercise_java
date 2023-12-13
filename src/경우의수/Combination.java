package 경우의수;

import java.util.ArrayList;
import java.util.LinkedList;

class Combination {
    public static void combination(int n, int r, int depth, int[] comArr, int start, int[] arr, ArrayList<ArrayList<Integer>> result) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : comArr) {
                temp.add(i);
            }
//            ArrayList<Integer> temp = Arrays.stream(comArr).boxed().collect(Collectors.toCollection(ArrayList::new));
            result.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            comArr[depth] = arr[i];
            combination(n, r, depth + 1, comArr, i + 1, arr, result);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int[] comArr = new int[2];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combination(arr.length, 2, 0, comArr, 0, arr, result);

        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
//        for (ArrayList<Integer> integers : result) {
//            System.out.println(integers);
//        }
    }
}