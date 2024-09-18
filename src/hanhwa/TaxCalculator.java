package hanhwa;

public class TaxCalculator {
    public static int solution(int[][] taxes, int income) {
        int totalTax = 0;
        int previousLimit = 0; // 이전 소득 구간의 상한선

        // foreach 문을 사용하여 세금 구간을 순회
        for (int[] tax : taxes) {
            int currentLimit = tax[0]; // 현재 소득 구간의 최대치
            int rate = tax[1]; // 현재 소득 구간의 세율

            if (currentLimit == 0 || income <= currentLimit) {
                // 현재 구간이 마지막 구간이거나 소득이 현재 구간의 최대치 이하인 경우
                totalTax += (income - previousLimit) * rate / 100;
                break;
            } else {
                // 현재 구간에 대한 소득 세금 계산
                totalTax += (currentLimit - previousLimit) * rate / 100;
            }

            previousLimit = currentLimit; // 다음 구간으로 이동
        }

        return totalTax;
    }

    public static void main(String[] args) {
        int[][] taxes1 = {{1200, 6}, {4600, 15}, {8800, 24}, {15000, 35}, {0, 38}};
        int income1 = 9500;
        System.out.println(solution(taxes1, income1)); // 출력: 1835

        int[][] taxes2 = {{1000, 1}, {0, 10}};
        int income2 = 2000;
        System.out.println(solution(taxes2, income2)); // 출력: 110

        int[][] taxes3 = {{1500, 12}, {3500, 23}, {5700, 29}, {0, 30}};
        int income3 = 6400;
        System.out.println(solution(taxes3, income3)); // 출력: 1488
    }
}
