package ScatterLab.SecondSolution;

public class Solution {

    public static double solution(double C, double F, double X) {
        double currentRate = 2.0;
        double accumulatedTime = 0.0;
        double minTime = X / currentRate;

        while (true) {
            double timeWithoutHiring = accumulatedTime + X / currentRate;

            accumulatedTime += C / currentRate;
            currentRate += F;
            double timeWithHiring = accumulatedTime + X / currentRate;

            if (timeWithHiring >= timeWithoutHiring) {
                minTime = timeWithoutHiring;
                break;
            }

            minTime = Math.min(minTime, timeWithHiring);
        }

        return minTime;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(String.format("%.6f", solution(30.0, 1.0, 2.0)));  // 1.000000
        System.out.println(String.format("%.6f", solution(30.0, 2.0, 100.0))); // 39.166667
        System.out.println(String.format("%.6f", solution(30.5, 3.14159, 1999.1999))); // 63.968001
        System.out.println(String.format("%.6f", solution(500.0, 4.0, 2000.0))); // 526.190476
    }
}
