package 자료구조.정렬;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 33, 17, 8, 45, 1, 7, 10, 37};
        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}

