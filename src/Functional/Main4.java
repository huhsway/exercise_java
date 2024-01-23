package Functional;

import java.util.stream.IntStream;

public class Main4 {

    /***
     * 길이가 같은 두 1차원 정수 배열 a,b가 매개변수로 주어집니다.
     * a와 b의 내적을 return 하도록하는 solution 함수를 만들어주세요.
     * 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다.
     * (n은 a,b의 길이)
     */

    static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};
        System.out.println(solution(a, b));
    }

}
