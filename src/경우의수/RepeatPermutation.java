package 경우의수;

import java.util.ArrayList;

public class RepeatPermutation {

    public static void repeatPermutation(int n, int r, int depth, int[] perArr, int[] arr, ArrayList<ArrayList<Integer>> result) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < perArr.length; i++) {
                temp.add(perArr[i]);
            }
//            ArrayList<Integer> temp = Arrays.stream(perArr).boxed().collect(Collectors.toCollection(ArrayList::new));
            result.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            perArr[depth] = arr[i];
            repeatPermutation(n, r, depth + 1, perArr, arr, result);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int[] perArr = new int[arr.length];
        boolean[] perCheck = new boolean[arr.length];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        repeatPermutation(arr.length, arr.length, 0, perArr, arr, result);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
