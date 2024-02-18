package 손코딩;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("십진수를 입력하세요: ");
        int decimal = scanner.nextInt();

        // 십진수를 이진수로 변환
        String binaryString = decimalToBinary(decimal);

        System.out.println("이진수로 변환된 값: " + binaryString);
    }

    // 십진수를 이진수로 변환하는 메소드
    public static String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();

        if (decimal == 0) {
            return "0";
        }

        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal /= 2;
        }

        return binary.toString();
    }
}
