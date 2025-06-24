package 무지의먹방라이브;

import java.util.*;

class Solution {

    public static class Food implements Comparable<Food> {
        private final int time;
        private final int index;

        public Food(int time, int index) {
            this.time = time;
            this.index = index;
        }

        public int getTime() {
            return this.time;
        }

        public int getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Food other) {
            return this.time - other.time;
        }
    }

    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        long totalTimes = 0;

        for (int i = 0; i < food_times.length; i++) {
            totalTimes += food_times[i];
            pq.offer(new Food(food_times[i], i + 1));
        }

        long timeSpent = 0;
        long previousFoodTime = 0;
        long foodRemaining = food_times.length;

        while (!pq.isEmpty() && timeSpent + (pq.peek().getTime() - previousFoodTime) * foodRemaining <= k) {
            int currentFoodTime = pq.poll().getTime();
            timeSpent += (currentFoodTime - previousFoodTime) * foodRemaining;
            foodRemaining--;
            previousFoodTime = currentFoodTime;
        }

        if (foodRemaining == 0) return -1;

        List<Food> remainingFoods = new ArrayList<>(pq);
        remainingFoods.sort(Comparator.comparing(Food::getIndex));

        return remainingFoods.get((int) ((k - timeSpent) % foodRemaining)).getIndex();

    }

}
