package LeetCode.Array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int maxValue = 1;
        int minValue = 1;
        int temp;

        for (int num : nums) {
            temp = maxValue;
            maxValue = Math.max(Math.max(maxValue * num, minValue * num), num);
            minValue = Math.min(Math.min(temp * num, minValue * num), num);
            result = Math.max(result, maxValue);
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        int maxProd = solution.maxProduct(nums);
        System.out.println(maxProd);
    }
}
