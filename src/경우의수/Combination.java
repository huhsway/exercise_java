package 경우의수;

import java.util.ArrayList;
import java.util.LinkedList;

class Combination {
    public int solution(int[] arr) {
        int answer = 0;

        int[] comArr = new int[2];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Combination(arr.length, 2, comArr, 0, 0, arr, result);

        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        return answer;
    }

    public static void Combination(int n, int r, int[] comArr, int index, int target, int[] arr, ArrayList<ArrayList<Integer>> result) {
        if (r == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i : comArr) {
                temp.add(i);
            }
            result.add(temp);
            return;
        }

        if (target == n) return;

        comArr[index] = arr[target];
        Combination(n, r-1, comArr, index+1, target+1, arr, result);
        Combination(n, r, comArr, index, target + 1, arr, result);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        Combination sol = new Combination();
        System.out.println(sol.solution(arr));
    }
}