package LeetCode.Array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxValue = Math.max(maxValue + nums[i], nums[i]);
            result = Math.max(result, maxValue);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = solution.maxSubArray(nums);
        System.out.println(maxSum);
    }
}
