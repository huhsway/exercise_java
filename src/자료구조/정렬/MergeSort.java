package 자료구조.정렬;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7, 4, 3, 2, 1, 6, 5};
        int[] sortedArray = mergeSort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] sortedArr = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                sortedArr[k++] = left[i++];
            } else {
                sortedArr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            sortedArr[k++] = left[i++];
        }

        while (j < right.length) {
            sortedArr[k++] = right[j++];
        }

        return sortedArr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
}

