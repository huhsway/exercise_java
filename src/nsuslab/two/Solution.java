package nsuslab.two;

public class Solution {
    public int solution(int[][] fees, int usage) {
        int totalFee = 0;
        int previousMaxUsage = 0;

        for (int i = 0; i < fees.length; i++) {
            int maxUsage = fees[i][0];
            int baseFee = fees[i][1];
            int unitFee = fees[i][2];

            // 기본 요금 적용 (사용량이 해당 구간에 속하면 한 번만 더해줌)
            if (usage <= maxUsage || maxUsage == 0) {
                totalFee += baseFee;
            }

            // 마지막 구간인 경우
            if (maxUsage == 0) {
                totalFee += (usage - previousMaxUsage) * unitFee;
                break;
            }

            // 현재 구간에 맞는 전력량을 계산
            if (usage > maxUsage) {
                totalFee += (maxUsage - previousMaxUsage) * unitFee;
            } else {
                totalFee += (usage - previousMaxUsage) * unitFee;
                break;
            }

            previousMaxUsage = maxUsage;
        }

        return totalFee;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] fees1 = { {200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435} };
        int usage1 = 320;
        System.out.println(solution.solution(fees1, usage1)); // 42760

        int[][] fees2 = { {200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435} };
        int usage2 = 450;
        System.out.println(solution.solution(fees2, usage2)); // 77550

        int[][] fees3 = { {1851, 1000, 100}, {0, 200, 155} };
        int usage3 = 1205;
        System.out.println(solution.solution(fees3, usage3)); // 121500

        int[][] fees4 = { {100, 415, 90}, {250, 1600, 389}, {0, 7000, 480} };
        int usage4 = 530;
        System.out.println(solution.solution(fees4, usage4)); // 208750
    }
}
