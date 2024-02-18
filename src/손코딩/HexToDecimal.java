package 손코딩;

import java.util.Scanner;

public class HexToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("16진수를 입력하세요: ");
        String hexString = scanner.nextLine();

        // 16진수를 10진수로 변환
        int decimal = hexToDecimal(hexString);

        System.out.println("10진수로 변환된 값: " + decimal);
    }

    // 16진수를 10진수로 변환하는 메소드
    public static int hexToDecimal(String hexString) {
        int decimal = 0;
        int length = hexString.length();

        for (int i = 0; i < length; i++) {
            char digit = hexString.charAt(i);
            int digitValue;
            if (digit >= '0' && digit <= '9') {
                digitValue = digit - '0';
            } else if (digit >= 'a' && digit <= 'f') {
                digitValue = digit - 'a' + 10;
            } else if (digit >= 'A' && digit <= 'F') {
                digitValue = digit - 'A' + 10;
            } else {
                throw new IllegalArgumentException("유효하지 않은 16진수입니다: " + digit);
            }
            decimal += digitValue * Math.pow(16, length - 1 - i);
        }
        return decimal;
    }
}
