package Functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionSortExample {

    static class Member {

        String name;
        int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 리스트에 데이터 삽입
        List<Member> members1 = new ArrayList<>();
        members1.add(new Member("윈터", 23));
        members1.add(new Member("카리나", 24));
        members1.add(new Member("닝닝", 22));

        // 정렬을 익명 클래스로 구현

        /**
         *  toString() 메서드를 오버라이드(override)하여 객체의 문자열 표현을 지정할 수 있습니다. 그러면 System.out.println() 메서드를 사용할 때 해당 객체의 toString() 메서드가 자동으로 호출되어 지정한 문자열 표현이 출력됩니다.
         *
         * Java에서는 모든 클래스가 Object 클래스를 상속하고 있는데, Object 클래스에는 toString() 메서드가 정의되어 있습니다. 기본적으로 toString() 메서드는 객체의 해시 코드나 클래스 이름과 함께 기본 문자열 표현을 반환합니다.
         */

        Collections.sort(members1, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o2.age - o1.age;
            }
        });

        System.out.println(members1);

        List<Member> members2 = new ArrayList<>();
        members2.add(new Member("윈터", 23));
        members2.add(new Member("카리나", 24));
        members2.add(new Member("닝닝", 22));

        // 정렬을 람다 표현식으로 구현
        members2.sort((o1, o2) -> o2.age - o1.age);

        System.out.println(members2);

    }


}
