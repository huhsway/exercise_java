// atoi함수 만들기
public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int index = 0, sign = 1, total = 0;
        int length = s.length();

        // 1. 공백 제거
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // 2. 부호 확인
        if (index < length) {
            char current = s.charAt(index);
            if (current == '+' || current == '-') {
                sign = (current == '-') ? -1 : 1;
                index++;
            }
        }

        // 3. 숫자 변환
        while (index < length) {
            char current = s.charAt(index);
            if (!Character.isDigit(current)) break;

            int digit = current - '0';

            // 4. 오버플로우/언더플로우 체크
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}