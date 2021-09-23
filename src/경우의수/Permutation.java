package 경우의수;

import java.util.ArrayList;
import java.util.LinkedList;

class Permutation {
    public int solution(int[] arr) {
        int answer = 0;

        int[] perArr = new int[arr.length];
        boolean[] perCheck = new boolean[arr.length];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Permutation(arr.length, arr.length, 0, perArr, perCheck, arr, result);

        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        return answer;
    }

    public static void Permutation(int n, int r, int depth, int[] perArr, boolean[] perCheck, int[] arr, ArrayList<ArrayList<Integer>> result){

        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < perArr.length; i++) {
                temp.add(perArr[i]);
            }
            result.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(perCheck[i] == false) {
                perArr[depth] = arr[i];
                perCheck[i] = true;
                Permutation(n, r, depth + 1, perArr, perCheck, arr, result);
                perCheck[i] = false;
                perArr[depth] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Permutation sol = new Permutation();
        System.out.println(sol.solution(arr));
    }
}