package 무지의먹방라이브;

import java.util.*;

public class Solution {

    public static class Food implements Comparable<Food> {
        int time, index;

        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }

        public int compareTo(Food other) {
            return this.time - other.time;
        }
    }

    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> foodQueue = new PriorityQueue<>(); // 음식을 시간 기준으로 정렬
        long totalTimes = 0; // 모든 음식을 먹는데 걸리는 총 시간

        for (int i = 0; i < food_times.length; i++) {
            totalTimes += food_times[i];
            foodQueue.offer(new Food(food_times[i], i + 1));
        }

        if (totalTimes <= k) return -1;

        long timeSpent = 0;
        long previousFoodTime = 0;
        long foodsRemaining = food_times.length;

        while (!foodQueue.isEmpty() && timeSpent + (foodQueue.peek().time - previousFoodTime) * foodsRemaining <= k) {
            int currentFoodTime = foodQueue.poll().time;
            timeSpent += (currentFoodTime - previousFoodTime) * foodsRemaining;
            foodsRemaining--;
            previousFoodTime = currentFoodTime;
        }

        if (foodQueue.isEmpty()) {
            return -1; // 모든 음식을 다 먹었으므로 -1 반환
        }

        List<Food> remainingFoods = new ArrayList<>(foodQueue);
        remainingFoods.sort(Comparator.comparingInt(a -> a.index));

        // k시간 후에 먹어야 할 음식의 인덱스 반환
        return remainingFoods.get((int) ((k - timeSpent) % foodsRemaining)).index;
    }
}
