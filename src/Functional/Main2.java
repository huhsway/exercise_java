package Functional;

import java.util.Arrays;

public class Main2 {

    /**
     chars() 메서드가 IntStream을 반환하는 이유는 IntStream이 보다 일반적이고 유용하게 사용될 수 있기 때문입니다.

     일반화된 처리: 문자를 정수 코드 포인트로 처리하면 문자열에 포함된 모든 문자에 대해 일반적인 연산을 수행할 수 있습니다. 이것은 문자를 숫자로 변환하거나 필터링하는 데 매우 유용합니다.

     유니코드 호환: IntStream은 모든 문자에 대한 유니코드 코드 포인트를 다룰 수 있으므로, 다양한 문자 집합과 언어를 처리할 때 유용합니다. 문자 집합 간에 코드 포인트의 범위가 다르기 때문에, IntStream을 사용하면 이러한 차이를 처리하기가 더 편리합니다.

     효율성: IntStream을 사용하여 문자열을 처리하면 내부적으로 메모리와 연산 효율성을 개선할 수 있습니다. 이는 문자를 char 타입보다 더 큰 범위의 정수로 다룰 때 유용합니다.

     물론, 문자 단위로 작업하는 경우 CharStream을 사용하는 것도 가능합니다. 그러나 IntStream은 보다 다양한 상황에서 활용할 수 있는 범용적인 도구로 사용됩니다. Java 스트림 API는 다양한 타입의 스트림을 제공하며, 문자열 처리의 일반적인 경우를 위해 IntStream이 선택된 것입니다.
     */

    /**
     .map은 Java의 스트림(Stream) API에서 사용되는 중요한 연산 중 하나로, 스트림의 각 요소를 변환하는 데 사용됩니다. .map 연산은 스트림의 요소를 하나씩 가져와서 지정된 함수 또는 람다 표현식을 적용하고, 그 결과를 새로운 스트림으로 매핑(변환)합니다.
     */

    // 숫자를 거꾸로 출력하는 문제

    static int[] solution(long n) {
        return new StringBuilder(String.valueOf(n))
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static void main(String[] args) {
        long n = 1234567890;
        System.out.println(Arrays.toString(solution(n)));
    }

}
