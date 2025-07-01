package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Calculates the number of times Maria breaks her best and worst records.
     *
     * @param scores A list of integers representing the scores for each game.
     * @return A list of two integers: the first is the number of times the highest score was broken,
     * and the second is the number of times the lowest score was broken.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Initialize max and min scores with the first game's score.
        int maxScore = scores.get(0);
        int minScore = scores.get(0);

        // Initialize counters for broken records.
        int maxCount = 0;
        int minCount = 0;

        // Iterate through the scores starting from the second game.
        for (int i = 1; i < scores.size(); i++) {
            int currentScore = scores.get(i);

            // Check if the current score is greater than the max score.
            if (currentScore > maxScore) {
                maxScore = currentScore;
                maxCount++;
            }
            // Check if the current score is less than the min score.
            else if (currentScore < minScore) {
                minScore = currentScore;
                minCount++;
            }
        }

        // Return the counts in a list.
        return Arrays.asList(maxCount, minCount);
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> scores1 = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);
        List<Integer> result1 = breakingRecords(scores1);
        System.out.println("Result for scores1: " + result1); // Expected: [2, 4]

        List<Integer> scores2 = Arrays.asList(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);
        List<Integer> result2 = breakingRecords(scores2);
        System.out.println("Result for scores2: " + result2); // Expected: [4, 0]
    }
}
