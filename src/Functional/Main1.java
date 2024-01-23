package Functional;

public class Main1 {

    // 주어진 문자열에서 p의 개수와 y의 개수가 일치하는지 확인하는 문제 (대소문자 구별 x)
    static boolean solution(String s) {
        s = s.toUpperCase();
        return s.chars().filter(e -> e == 'P').count() == s.chars().filter(e -> e == 'Y').count();
    }

//    static boolean solution(String s) {
//        s = s.toUpperCase();
//        IntStream chars = s.chars();
//
////        현재 코드에서 chars 스트림은 두 번 사용되고 있습니다. 첫 번째 사용은 'P' 문자를 필터링하여 countP를 계산하는데 사용되고, 두 번째 사용은 'Y' 문자를 필터링하여 countY를 계산하는데 사용됩니다. 이런 경우에는 chars 스트림을 한 번 더 사용하려고 하면 이미 소비된 스트림이므로 예외가 발생할 것입니다.
//
//        long countP = chars.filter(e -> e == 'P').count();
//        long countY = chars.filter(e -> e == 'Y').count();
//        return countP == countY;
//    }
    public static void main(String[] args) {
        String s = "ASDFVPPPYNFDSFPTYYYpyyyppPYasdf";
        System.out.println(solution(s));


    }

}
