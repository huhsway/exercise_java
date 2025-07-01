package HackerRank;

import java.io.*;
import java.util.*;

class Result {

    // 51432
    // 52431
    // 52134

    public static String biggerIsGreater(String w) {
        char[] charArray = w.toCharArray();
        int n = charArray.length;

        // 1. 뒤에서부터 첫 번째 '오름차순' 지점 (pivot) 찾기
        int i = -1; // 피벗 인덱스 초기화
        for (int k = n - 2; k >= 0; k--) {
            if (charArray[k] < charArray[k + 1]) {
                i = k;
                break; // 조건을 만족하면 바로 반복문 종료
            }
        }

        // 만약 피벗을 찾지 못했다면 (i가 -1인 경우), 전체가 내림차순 정렬 상태
        if (i == -1) {
            return "no answer";
        }

        // 2. 제일 뒤부터 시작해서 피벗보다 큰 첫 번째 문자 찾기
        int j = -1; // 교환할 문자 인덱스 초기화
        for (int k = n - 1; k > i; k--) {
            if (charArray[k] > charArray[i]) {
                j = k;
                break; // 조건을 만족하면 바로 반복문 종료
            }
        }

        // 3. 피벗과 찾은 문자 교환
        swap(charArray, i, j);

        // 4. 피벗 뒤쪽 부분(i+1부터 끝까지) 오름차순으로 정렬 (뒤집기)
        reverse(charArray, i + 1, n - 1);

        return new String(charArray);
    }

    // 배열의 두 요소를 교환하는 헬퍼 메서드
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 배열의 특정 부분을 뒤집는 헬퍼 메서드 (오름차순 정렬과 동일한 효과)
    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

// 이 아래 main 함수는 동일하므로 생략합니다.
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // ... (main 함수 내용) ...
    }
}
*/
