package 무지의먹방라이브;

import java.util.*;

class Food implements Comparable<Food> {
    int time, index;

    Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

public class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        long summary = 0;

        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
            pq.offer(new Food(food_times[i], i + 1));
        }

        if (summary <= k) return -1;

        long previous = 0;
        long length = food_times.length;

        while (pq.peek().time - previous <= k / length) {
            int now = pq.poll().time;
            k -= (now - previous) * length;
            length--;
            previous = now;
        }

        List<Food> remainingFoods = new ArrayList<>(pq);

        remainingFoods.sort(Comparator.comparingInt(a -> a.index));

        return remainingFoods.get((int) (k % length)).index;
    }
}
