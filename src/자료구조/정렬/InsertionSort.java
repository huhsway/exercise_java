package 자료구조.정렬;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {10, 34, 45, 50, 8, 48, 14, 41, 43, 1, 46, 9, 7, 25, 36};
        insertionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int cur = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = cur;
        }
    }
}
