package LeetCode.Array;

import java.util.Arrays;

// 네이버 면접 복기 토대로 만든거
public class RotateArray {

    public int[] rotateArray(int[] arr, int t) {

        int n = arr.length - 1;
        for (int i = 0; i < t; i++) {

            int last = arr[n];

            for (int j = n; j > 0; j--) {
                arr[j] = arr[j-1];
            }

            arr[0] = last;

        }
        return arr;
    }

//    // 배열 하나 더쓰고 for문 1번으로
//    public int[] rotateArray(int[] arr, int t) {
//        int n = arr.length;
//        t = t % n; // 배열 길이보다 큰 t에 대응하기 위해 t를 배열 길이로 나눈 나머지를 사용합니다.
//
//        int[] rotatedArr = new int[n];
//        for (int i = 0; i < n; i++) {
//            rotatedArr[(i + t) % n] = arr[i];
//        }
//
//        return rotatedArr;
//    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int t = 3;
        RotateArray solution = new RotateArray();
        System.out.println(Arrays.toString(solution.rotateArray(arr, t)));
    }

}
