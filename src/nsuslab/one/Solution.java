package nsuslab.one;

import java.util.*;

public class Solution {
    public String[] solution(int k, int a, int b, String init_password, int[] times) {
        // 초기 비밀번호를 int로 변환
        int currentPassword = Integer.parseInt(init_password);

        // 결과 저장을 위한 배열
        String[] result = new String[times.length];

        // 각 times[i]에 해당하는 비밀번호 계산
        for (int i = 0; i < times.length; i++) {
            int time = times[i];
            int cycles = time / k; // 몇 번째 비밀번호인지 계산

            // 주어진 규칙에 따라 새로운 비밀번호 계산
            int password = currentPassword;
            for (int j = 0; j < cycles; j++) {
                password = (a * password + b) % 10000;
            }

            // 비밀번호를 네 자리 문자열로 맞추기
            result[i] = String.format("%04d", password);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // 테스트 케이스 1
        int k1 = 30;
        int a1 = 25;
        int b1 = 13;
        String init_password1 = "0001";
        int[] times1 = {0, 29, 30, 119, 120};
        System.out.println(Arrays.toString(sol.solution(k1, a1, b1, init_password1, times1))); // ["0001", "0001",  "0038",  "4088",  "2213"]

        // 테스트 케이스 2
        int k2 = 1;
        int a2 = 1;
        int b2 = 1000;
        String init_password2 = "7123";
        int[] times2 = {2, 3, 4};
        System.out.println(Arrays.toString(sol.solution(k2, a2, b2, init_password2, times2))); // ["9123", "0123",  "1123"]
    }
}