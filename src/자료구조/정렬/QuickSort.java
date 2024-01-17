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

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && array[left] <= array[pivot]) {
                left++;
            }
            while (right > start && array[right] >= array[pivot]) {
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

        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
    }
}
