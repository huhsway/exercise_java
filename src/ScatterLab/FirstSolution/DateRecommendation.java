package ScatterLab.FirstSolution;

import java.util.Arrays;

public class DateRecommendation {

    public static int[] solution(int[][] week1, int[][] week2) {
        int recommendedDay1 = getBestDay(week1);
        int notRecommendedDay1 = getWorstDay(week1);

        int recommendedDay2 = getBestDay(week2);
        int notRecommendedDay2 = getWorstDay(week2);

        return new int[]{recommendedDay1, notRecommendedDay1, recommendedDay2, notRecommendedDay2};
    }

    private static int getBestDay(int[][] week) {
        int[] scores = calculateScores(week);

        // 추천 순위: 토, 금, 일, 수, 목, 화, 월
        int[] priority = {5, 4, 6, 2, 3, 1, 0};

        int bestDay = -1;
        int maxScore = Integer.MIN_VALUE;

        for (int day : priority) {
            if (scores[day] > maxScore) {
                maxScore = scores[day];
                bestDay = day;
            }
        }
        return bestDay;
    }

    private static int getWorstDay(int[][] week) {
        int[] scores = calculateScores(week);
        boolean[] conditionsMet = new boolean[7];

        for (int i = 0; i < 7; i++) {
            int temp = week[i][2];
            int skyCondition = week[i][0];
            int rainCondition = week[i][1];

            conditionsMet[i] = (skyCondition == 4 || rainCondition == 1) || temp >= 30 || temp <= 0;
        }

        int worstDay = -1;
        int minScore = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            if (conditionsMet[i] && scores[i] < minScore) {
                minScore = scores[i];
                worstDay = i;
            }
        }
        return worstDay;
    }

    private static int[] calculateScores(int[][] week) {
        int[] scores = new int[7];

        for (int i = 0; i < 7; i++) {
            int temp = week[i][2];
            int skyCondition = week[i][0];
            int rainCondition = week[i][1];

            int tempScore = 20 - Math.abs(22 - temp);
            int weatherScore = calculateWeatherScore(skyCondition, rainCondition);

            scores[i] = tempScore + weatherScore;
        }

        return scores;
    }

    private static int calculateWeatherScore(int skyCondition, int rainCondition) {
        if (rainCondition == 1) {
            return 5;
        } else if (rainCondition == 2) {
            return 14;
        } else {
            switch (skyCondition) {
                case 1:
                case 2:
                    return 20;
                case 3:
                    return 17;
                case 4:
                    return 10;
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] week1 = {
                {1, 0, 11},
                {3, 1, 15},
                {2, 0, 16},
                {4, 0, 17},
                {2, 0, 15},
                {2, 1, 14},
                {2, 0, 12}
        };
        int[][] week2 = {
                {4, 0, 12},
                {1, 0, 16},
                {3, 0, 18},
                {3, 0, 17},
                {2, 0, 15},
                {3, 2, 22},
                {2, 1, 17}
        };

        int[] result = solution(week1, week2);
        System.out.println(Arrays.toString(result)); // [2, 5, 5, 0]
    }
}
