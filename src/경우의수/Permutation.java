package 경우의수;

import java.util.*;
import java.util.stream.Collectors;

class Permutation {

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[] arr = {3, 6, 9};
        List<List<Integer>> result = getPermutation(n, m, arr);

        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static List<List<Integer>> getPermutation(int n, int m, int[] arr) {
        boolean[] visited = new boolean[n];
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        dfs(n, m, arr, 0, visited, temp, answer);
        return answer;
    }

    private static void dfs(int n, int m, int[] arr, int depth, boolean[] visited, List<Integer> temp, List<List<Integer>> answer) {
        if (depth == m) {
            answer.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true; // mark as visited
                    temp.add(arr[i]);
                    dfs(n, m, arr, depth + 1,  visited, temp, answer);
                    temp.remove(temp.size() - 1); // backtrack
                    visited[i] = false; // reset the visited status
                }
            }
        }
    }


//    public static void permutation(int n, int r, int depth, int[] perArr, boolean[] perCheck, int[] arr, List<List<Integer>> result) {
//        if (depth == r) {
//            List<Integer> temp = new ArrayList<>();
//            for (int i : perArr) {
//                temp.add(i);
//            }
////            List<Integer> temp = Arrays.stream(perArr).boxed().collect(Collectors.toCollection(ArrayList::new));
//            result.add(temp);
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!perCheck[i]) {
//                perArr[depth] = arr[i];
//                perCheck[i] = true;
//                permutation(n, r, depth + 1, perArr, perCheck, arr, result);
//                perCheck[i] = false;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1heck = new boolean[arr.length];
//        List<List<Integer>> result = new ArrayList<>();
//
//        permutation(arr.length, arr.length, 0, perArr, perCheck, arr, result);
//
//        for (List<Integer> int, 2, 3, 4};
//
//        int[] perArr = new int[arr.length];
//        boolean[] perCegers : result) {
//            System.out.println(integers);
//        }
//    }



//    public static List<List<Integer>> getPermutation(int n, int m, int[] arr) {
//        boolean[] visited = new boolean[n];
//        List<Integer> temp = new ArrayList<>();
//        List<List<Integer>> answer = new ArrayList<>();
//
//        DFS(0, n, m, arr, visited, temp, answer);
//        return answer;
//    }
//
//    private static void DFS(int depth, int n, int m, int[] arr, boolean[] visited, List<Integer> temp, List<List<Integer>> answer) {
//        if (depth == m) {
//            answer.add(new ArrayList<>(temp));
//        } else {
//            for (int i = 0; i < n; i++) {
//                if (!visited[i]) {
//                    visited[i] = true; // Mark as visited
//                    temp.add(arr[i]);
//                    DFS(depth + 1, n, m, arr, visited, temp, answer);
//                    temp.remove(temp.size() - 1); // Remove last element when backtracking
//                    visited[i] = false; // Reset visited status
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 5; // Total number of elements in array
//        int m = 3; // Number of elements to select
//        int[] arr = {1, 2, 3, 4, 5}; // Example array
//
//        List<List<Integer>> permutations = getPermutation(n, m, arr);
//        for (List<Integer> permutation : permutations) {
//            System.out.println(permutation);
//        }
//    }

}