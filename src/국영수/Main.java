package 국영수;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

// https://velog.io/@xxwb__/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4-%EC%A0%95%EB%A0%AC-%EA%B5%AD%EC%98%81%EC%88%98

/*
1. 국어 내림
2. 국어 같으면 영어 오름
3. 국어, 영어 같으면 수학 내림
4. 국어, 영어, 수학 같으면 이름 올림

입력 예시
12
Junkyu 50 60 100
SangKeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90

출력 예시
Donghyuk
Sangkeun
Sunyoung
nsj
Wonseob
Sanghyun
Sei
Kangsoo
Haebin
Junkyu
Soong
Taewhan
 */

//class Student implements Comparable<Student> {
//
//    private String name;
//    private int kor;
//    private int eng;
//    private int math;
//
//    public Student(String name, int kor, int eng, int math) {
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.math = math;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public int compareTo(Student other) {
//        if (this.kor == other.kor && this.eng == other.eng && this.math == other.math) {
//            return this.name.compareTo(other.name);
//        }
//        if (this.kor == other.kor && this.eng == other.eng) {
//            return other.math - this.math;
//        }
//        if (this.kor == other.kor) {
//            return this.eng - other.eng;
//        }
//        return other.kor - this.kor;
//    }
//
//}
//
///**
// *
// BufferedReader와 StringTokenizer를 Scanner에 선호하는 이유는 다음과 같습니다:
//
// 성능: BufferedReader와 StringTokenizer는 대량의 입력을 더 효율적으로 처리할 수 있으며, 더 빠르게 입력을 파싱할 수 있습니다. 특히, 대규모 입력을 처리할 때 Scanner보다 빠를 수 있습니다.
//
// 메모리 사용: Scanner는 내부 버퍼를 사용하며, 이로 인해 메모리 사용량이 높을 수 있습니다. 반면에 BufferedReader와 StringTokenizer는 더 적은 메모리를 사용합니다.
//
// 문자열 처리: StringTokenizer는 문자열을 더 쉽게 분할할 수 있습니다. 특히, 공백 문자 또는 다른 구분자를 기준으로 문자열을 나눌 때 유용합니다.
//
// 유연성: BufferedReader와 StringTokenizer는 다양한 입력 소스 (파일, 표준 입력, 문자열 등)에서 사용할 수 있으며, 개발자가 더 많은 제어를 할 수 있습니다.
//
// 에러 처리: BufferedReader는 예외 처리를 더 쉽게 할 수 있도록 지원합니다. Scanner는 예외 처리를 잡기 어려울 수 있습니다.
//
// 물론 Scanner도 편리한 입력 처리 도구 중 하나이며, 간단한 입력 처리에는 충분할 수 있습니다. 그러나 대량의 데이터나 성능이 중요한 상황에서는 BufferedReader와 StringTokenizer를 사용하는 것이 일반적으로 더 효율적입니다.
// */
//class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int n = Integer.parseInt(br.readLine());
//
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            String name = st.nextToken();
//            int kor = Integer.parseInt(st.nextToken());
//            int eng = Integer.parseInt(st.nextToken());
//            int math = Integer.parseInt(st.nextToken());
//            students.add(new Student(name, kor, eng, math));
//        }
//
//        Collections.sort(students);
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(students.get(i).getName());
//        }
//    }
//
//}

class Main {

//    public static class Student {
//        private String name;
//        private int kor;
//        private int eng;
//        private int math;
//
//        public Student(String name, int kor, int eng, int math) {
//            this.name = name;
//            this.kor = kor;
//            this.eng = eng;
//            this.math = math;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public int getKor() {
//            return kor;
//        }
//
//        public int getEng() {
//            return eng;
//        }
//
//        public int getMath() {
//            return math;
//        }
//    }
//
//    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int n = Integer.parseInt(br.readLine());
//
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            String name = st.nextToken();
//            int kor = Integer.parseInt(st.nextToken());
//            int eng = Integer.parseInt(st.nextToken());
//            int math = Integer.parseInt(st.nextToken());
//            students.add(new Student(name, kor, eng, math));
//        }

//    /**
//     * students.sort()와 students.stream().sorted() 둘 다 정렬을 수행하는데 사용할 수 있지만, 두 가지 접근 방식 간에는 약간의 차이가 있습니다.
//     *
//     * students.sort()를 사용하는 경우:
//     *
//     * 이 접근 방식은 주어진 List<Student>를 직접 변경하여 정렬합니다. 따라서 students 리스트가 정렬된 상태로 변경됩니다.
//     * 정렬 후에는 students 리스트를 순회하면 정렬된 순서대로 학생들이 나올 것입니다.
//     * 이 방식은 기존의 리스트를 수정하므로 주의해야 합니다. 원래 순서가 필요한 경우에는 사용하기 어렵습니다.
//     * students.stream().sorted()를 사용하는 경우:
//     *
//     * 이 접근 방식은 주어진 List<Student>를 변경하지 않고 정렬된 새로운 Stream<Student>를 반환합니다.
//     * 정렬 후에는 원래 students 리스트는 그대로 남아 있으며, 정렬된 학생들을 순회하려면 스트림을 사용해야 합니다.
//     * 이 방식은 원래 리스트를 변경하지 않고 정렬된 결과를 얻을 수 있어 원본 데이터의 순서를 유지하고자 할 때 유용합니다.
//     * 따라서 두 가지 방식 중 어떤 것을 선택할지는 필요한 작업 흐름과 원하는 동작에 따라 달라질 것입니다. 필요에 따라 두 가지 방식 중 하나를 선택하면 됩니다.
//     * */

//    students.sort(Comparator.comparing(Student::getKor, Comparator.reverseOrder())
//            .thenComparing(Student::getEng)
//                .thenComparing(Student::getMath, Comparator.reverseOrder())
//            .thenComparing(Student::getName));

//        students.stream()
//                .sorted(Comparator
//                        .comparing(Student::getKor, Comparator.reverseOrder())
//                        .thenComparing(Student::getEng)
//                        .thenComparing(Student::getMath, Comparator.reverseOrder())
//                        .thenComparing(Student::getName))
//                .forEach(s -> System.out.println(s.getName()));
//    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String[]> arr = new ArrayList<>();

        String[] data = {
                "John 25 10 100",
                "Alice 22 8 95",
                "Bob 30 12 120",
                "David 25 8 100"
        };

        Arrays.stream(data)
                .map(i -> i.split(" "))
                .sorted(Comparator.<String[], Integer>comparing(a -> Integer.parseInt(a[1]), Comparator.reverseOrder())
                        .thenComparing(a -> Integer.parseInt(a[2]))
                        .thenComparing(a -> Integer.parseInt(a[3]), Comparator.reverseOrder())
                        .thenComparing(a -> a[0]))
                .map(s -> s[0])
                .forEach(System.out::println);

//        arr.sort(Comparator.<String[], Integer>comparing(a -> Integer.parseInt(a[1]), Comparator.reverseOrder())
//                .thenComparing(a -> Integer.parseInt(a[2]))
//                .thenComparing(a -> Integer.parseInt(a[3]), Comparator.reverseOrder())
//                .thenComparing(a -> a[0]));
//
//        names = arr.stream().map(a -> a[0]).collect(Collectors.toList());
//
//        names.forEach(System.out::println);
    }

}




