package 자료구조.정렬;

public class MergeSort {
    public static void main(String[] args) {
        // 초기 정렬되지 않은 배열
        int[] arr = {7, 4, 3, 2, 1, 6, 5};
        // 병합 정렬 시작
        mergeSort(arr, 0, arr.length - 1);

        // 정렬된 배열 출력
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 병합 정렬 함수: 배열의 특정 부분을 정렬
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 중간 지점을 찾아 배열을 두 부분으로 나눔
            int mid = (left + right) / 2;

            // 왼쪽 부분을 재귀적으로 정렬
            mergeSort(arr, left, mid);
            // 오른쪽 부분을 재귀적으로 정렬
            mergeSort(arr, mid + 1, right);

            // 두 부분을 병합
            merge(arr, left, mid, right);
        }
    }

    // 두 부분 배열을 병합하고 정렬하는 함수
    public static void merge(int[] arr, int left, int mid, int right) {
        // 임시 배열을 생성하여 병합된 요소들을 저장
        int[] temp = new int[right - left + 1];
        // i: 왼쪽 부분 배열의 시작, j: 오른쪽 부분 배열의 시작, k: 임시 배열의 인덱스
        int i = left;
        int j = mid + 1;
        int k = 0;

        // 왼쪽과 오른쪽 부분 배열을 순회하며 요소들을 비교하고, 임시 배열에 정렬하여 저장
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 왼쪽 부분 배열에 남아 있는 요소들을 임시 배열에 복사
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 오른쪽 부분 배열에 남아 있는 요소들을 임시 배열에 복사
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // 임시 배열의 요소들을 원래 배열에 복사하여 병합 완료
        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx - left];
        }
    }
}
