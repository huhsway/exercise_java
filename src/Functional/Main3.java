package Functional;

import java.util.Arrays;

public class Main3 {

    /**
     arr의 원소 중 divisor로 나누어 떨어지는 수를 배열에 담아 정렬하여 반환.

     반환 배열의 크기가 0이면, 배열에 -1 하나 담아서 반환
     */

    static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(i -> i % divisor == 0)
                .sorted()
                .toArray();

        return answer.length == 0 ? new int[]{-1} : answer;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int divisor = 2;
        System.out.println(Arrays.toString(solution(arr, divisor)));
    }

}
