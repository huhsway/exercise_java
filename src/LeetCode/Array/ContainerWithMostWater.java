package LeetCode.Array;

public class ContainerWithMostWater {
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
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
}
