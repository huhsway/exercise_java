package 국영수;

import java.util.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

// https://velog.io/@xxwb__/%EC%9D%B4%EA%B2%83%EC%9D%B4-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4-%EC%A0%95%EB%A0%AC-%EA%B5%AD%EC%98%81%EC%88%98

//class Student implements Comparable<Student> {
//
//    private String name;
//    private int kor;
//    private int eng;
//    private int m;
//
//    public Student(String name, int kor, int eng, int m) {
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.m = m;
//    }
//
//    /*
//    [ 정렬 기준 ]
//    1) 두 번째 원소를 기준으로 내림차순 정렬
//    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
//    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
//    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
//    */
//
//    public String getName() {
//        return this.name; }
//
//    @Override
//    public int compareTo(Student other) {
//        if (this.kor == other.kor && this.eng == other.eng && this.m == other.m) {
//            return this.name.compareTo(other.name);
//        }
//        if (this.kor == other.kor && this.eng == other.eng) {
//            return Integer.compare(other.m, this.m);
//        }
//        if (this.kor == other.kor) {
//            return Integer.compare(this.eng, other.eng);
//        }
//        return Integer.compare(other.kor, this.kor);
//    }
//
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        ArrayList<Student> students = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            String name = sc.next();
//            int kor = sc.nextInt();
//            int eng = sc.nextInt();
//            int m = sc.nextInt();
//            students.add(new Student(name, kor, eng, m));
//        }
//
//        Collections.sort(students);
//
//        // 정렬된 학생 정보에서 이름만 출력
//        for (int i = 0; i < n; i++) {
//            System.out.println(students.get(i).getName());
//        }
//    }
//}

class Main {

    private static class Student {
        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.nextLine();

            List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                String name = info[0];
                int kor = Integer.parseInt(info[1]);
                int eng = Integer.parseInt(info[2]);
                int math = Integer.parseInt(info[3]);
                students.add(new Student(name, kor, eng, math));
            }

            students.stream()
                    .sorted(Comparator
                            .comparing(Student::getKor, Comparator.reverseOrder())
                            .thenComparing(Student::getEng)
                            .thenComparing(Student::getMath, Comparator.reverseOrder())
                            .thenComparing(Student::getName))
                    .forEach(s -> System.out.println(s.getName()));
        }
    }

}


