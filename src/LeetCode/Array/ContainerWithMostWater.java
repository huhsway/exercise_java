package LeetCode.Array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int standard = Math.min(height[start], height[end]);
            int gap = (end - start) * standard;

            if (height[end] > height[start]) {
                start++;
            } else {
                end--;
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
