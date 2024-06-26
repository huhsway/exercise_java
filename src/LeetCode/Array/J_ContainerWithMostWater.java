package LeetCode.Array;

// https://leetcode.com/problems/container-with-most-water/
public class J_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        int standard, gap;

        while (left < right) {
            standard = Math.min(height[left], height[right]);
            gap = (right - left) * standard;


            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }

            result = Math.max(result, gap);
        }

        return result;
    }

    public static void main(String[] args) {
        J_ContainerWithMostWater solution = new J_ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
}
