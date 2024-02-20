package LeetCode.Array;

// https://leetcode.com/problems/product-of-array-except-self/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        // 먼저 왼쪽 곱셈 결과를 계산하고 저장합니다.
        int left = 1;
        for (int i = 0; i < length; i++) {
            result[i] = left;
            left *= nums[i];
        }

        // 이제 오른쪽 곱셈 결과를 계산하고 왼쪽 곱셈 결과와 곱합니다.
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
