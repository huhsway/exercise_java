package 이진탐색범위찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int lowerBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static int upperBound(int[] arr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        // 유의: lowerBound와 upperBound는 right 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 데이터의 개수 N, 찾고자 하는 값 x 입력받기
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        // 전체 데이터 입력받기
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 값이 [x, x] 범위에 있는 데이터의 개수 계산
        int cnt = countByRange(arr, x, x);

        // 값이 x인 원소가 존재하지 않는다면
        if (cnt == 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}