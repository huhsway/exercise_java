package 손코딩;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {3, 2, 7, 3, 2, 7, 5, 8};

        // 중복 제거 및 순서 유지
        int[] result = removeDuplicates(array);

        // 결과 출력
        System.out.println("중복 제거 및 순서 유지된 배열: " + Arrays.toString(result));
    }

    public static int[] removeDuplicates(int[] array) {
        // 중복 제거 및 순서 유지를 위해 LinkedHashMap 사용
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : array) {
            map.put(num, num);
        }
        // 중복 제거 및 순서 유지된 배열 생성
        int[] result = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            result[index++] = key;
        }
        return result;
    }
}

//public class RemoveDuplicatesUsingStream {
//    public static void main(String[] args) {
//        int[] array = {3, 2, 7, 3, 2, 7, 5, 8};
//
//        // 중복 제거 및 순서 유지
//        int[] result = removeDuplicates(array);
//
//        // 결과 출력
//        System.out.println("중복 제거 및 순서 유지된 배열: " + Arrays.toString(result));
//    }
//
//    public static int[] removeDuplicates(int[] array) {
//        return Arrays.stream(array)
//                .distinct() // 중복 제거
//                .toArray(); // 배열로 변환
//    }
//}