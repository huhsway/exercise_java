package LeetCode.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> output = new ArrayList<>();
        int i = 0;

        // newInterval 이전의 간격들을 output에 추가
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }

        // 겹치는 간격들을 병합
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        output.add(newInterval);

        // 나머지 간격들을 output에 추가
        while (i < intervals.length) {
            output.add(intervals[i]);
            i++;
        }

        // List를 2차원 배열로 변환
        int[][] result = new int[output.size()][2];
        for (int j = 0; j < output.size(); j++) {
            result[j] = output.get(j);
        }

        return result;
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = solution.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}

