package 무지의먹방라이브;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {

    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() { return this.time; }

    public int getIndex() { return this.index; }

    // 시간이 짧은 것이 우선순위를 가지도록 설정
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }

}

class Solution {

    public int solution(int[] food_times, long k) {
        long summary = 0;
        for (int i = 0; i < food_times.length; i++){
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0;
        long previous = 0;
        long length = food_times.length;

        while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * length;
            length -= 1;
            previous = now;
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // 음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });
        return result.get((int) (k - summary % length)).getIndex();
    }

}
