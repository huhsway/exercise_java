package 이진탐색값찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 이진 탐색 소스코드 구현(반복문)
    public static int binarySearch(int[] arr, int target, int left, int right) {
        while(left <= right) {
            int mid = (left + right) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) right = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else left = mid + 1;
        }
        return -1;
    }

//    // 재귀적 이진 탐색 메소드
//    public static int binarySearch(int[] arr, int target, int left, int right) {
//        if (left > right) {
//            return -1; // 요소를 찾지 못한 경우
//        }
//
//        int mid = left + (right - left) / 2;
//
//        if (arr[mid] == target) {
//            return mid; // 요소를 찾은 경우
//        } else if (arr[mid] > target) {
//            // 중간 값이 찾는 값보다 큰 경우, 왼쪽 부분 배열에서 다시 탐색
//            return binarySearch(arr, target, left, mid - 1);
//        } else {
//            // 중간 값이 찾는 값보다 작은 경우, 오른쪽 부분 배열에서 다시 탐색
//            return binarySearch(arr, target, mid + 1, right);
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // 전체 원소 입력받기
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색 수행 결과 출력
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }

}
