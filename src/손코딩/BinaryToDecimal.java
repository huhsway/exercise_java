package 손코딩;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이진수를 입력하세요: ");
        String binaryString = scanner.nextLine();

        // 이진수를 십진수로 변환
        int decimal = binaryToDecimal(binaryString);

        System.out.println("십진수로 변환된 값: " + decimal);
    }

    // 이진수를 십진수로 변환하는 메소드
    public static int binaryToDecimal(String binaryString) {
        int decimal = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            char digit = binaryString.charAt(i);
            // 이진수의 각 자릿수를 처리
            if (digit == '1') {
                decimal += Math.pow(2, length - 1 - i);
            } else if (digit != '0') {
                // 이진수가 아닌 값이 들어오면 오류 처리
                throw new IllegalArgumentException("이진수가 아닌 값이 포함되어 있습니다: " + digit);
            }
        }
        return decimal;
    }
}
