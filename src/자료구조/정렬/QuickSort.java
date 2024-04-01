package 자료구조.정렬;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        quickSort(array, 0, array.length - 1);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= right && array[left] <= array[pivot]) {
                left++;
            }
            while (left <= right && array[right] >= array[pivot]) {
                right--;
            }

            if (left > right) {
                int temp = array[pivot];
                array[pivot] = array[right];
                array[right] = temp;
            } else {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        return right;
    }
}
