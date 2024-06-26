package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class A_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> vals = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (vals.containsKey(complement)) {
                return new int[]{vals.get(complement), i};
            } else {
                vals.put(nums[i], i);
            }
        }
        return null; // 해당 조건을 만족하는 두 숫자가 없을 경우
    }

    public static void main(String[] args) {
        A_TwoSum solution = new A_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No such indices found.");
        }
    }
}
