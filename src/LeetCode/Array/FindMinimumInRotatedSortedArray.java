package LeetCode.Array;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int m = (i + j) / 2;

            if (nums[m] > nums[j]) {
                // 중간 지점의 값이 오른쪽 끝 지점의 값보다 크다면, 회전된 부분이 왼쪽 있음.
                // 최솟값은 중간 지점의 오른쪽에 있으므로 i를 중간 지점 다음으로 이동합니다.
                i = m + 1;
            } else {
                // 중간 지점의 값이 오른쪽 끝 지점의 값보다 작거나 같다면, 회전된 부분이 오른쪽에 있음.
                // 최솟값은 중간 지점의 왼쪽에 있으므로 j를 중간 지점으로 이동합니다.
                j = m;
            }
        }

        return nums[i];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = solution.findMin(nums);
        System.out.println(min);
    }

}
