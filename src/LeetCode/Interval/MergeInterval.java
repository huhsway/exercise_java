package LeetCode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] previous = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (previous[1] >= intervals[i][0]) {
                previous[1] = Math.max(previous[1], intervals[i][1]);
            } else {
                result.add(previous);
                previous = intervals[i];
            }
        }

        result.add(previous);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeInterval solution = new MergeInterval();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

