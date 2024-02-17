package LeetCode.Array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int standard = Math.min(height[left], height[right]);
            int gap = (right - left) * standard;

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }

            max = Math.max(max, gap);
        }

        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
}
