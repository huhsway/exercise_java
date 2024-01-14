package 국영수;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

// https://velog.io/@xxwb__/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4-%EC%A0%95%EB%A0%AC-%EA%B5%AD%EC%98%81%EC%88%98

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
//        ArrayList<Student> students = new ArrayList<>();
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

//    private static class Student {
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
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String line = scanner.nextLine();
//            String[] info = line.split(" ");
//            String name = info[0];
//            int kor = Integer.parseInt(info[1]);
//            int eng = Integer.parseInt(info[2]);
//            int math = Integer.parseInt(info[3]);
//            students.add(new Student(name, kor, eng, math));
//        }
//
//        students.stream()
//                .sorted(Comparator
//                        .comparing(Student::getKor, Comparator.reverseOrder())
//                        .thenComparing(Student::getEng)
//                        .thenComparing(Student::getMath, Comparator.reverseOrder())
//                        .thenComparing(Student::getName))
//                .forEach(s -> System.out.println(s.getName()));
//    }

//    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//        List<String[]> arr = new ArrayList<>();
//
//        // 데이터 추가 (예시)
//        arr.add("John 25 10 100".split(" "));
//        arr.add("Alice 22 8 95".split(" "));
//        arr.add("Bob 30 12 120".split(" "));
//        arr.add("David 25 8 100".split(" "));
//
//        List<String[]> result = new ArrayList<>();
//        result = arr;
//
//        Collections.sort(result, new Comparator<String[]>() {
//            @Override
//            public int compare(String[] a, String[] b) {
//                int cmp = Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
//                if (cmp == 0) {
//                    cmp = Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
//                    if (cmp == 0) {
//                        cmp = Integer.parseInt(b[3]) - Integer.parseInt(a[3]);
//                        if (cmp == 0) {
//                            cmp = a[0].compareTo(b[0]);
//                        }
//                    }
//                }
//                return cmp;
//            }
//        });
//
//        for (String[] v : result) {
//            names.add(v[0]);
//        }
//
//        for (String name : names) {
//            System.out.println(name);
//        }
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

        for (String item : data) {
            arr.add(item.split(" "));
        }

        arr.sort(Comparator.<String[], Integer>comparing(a -> Integer.parseInt(a[1]), Comparator.reverseOrder())
                .thenComparing(a -> Integer.parseInt(a[2]), Comparator.reverseOrder())
                .thenComparing(a -> Integer.parseInt(a[3]), Comparator.reverseOrder())
                .thenComparing(a -> a[0]));

        names = arr.stream().map(a -> a[0]).collect(Collectors.toList());

        names.forEach(System.out::println);
    }

}




