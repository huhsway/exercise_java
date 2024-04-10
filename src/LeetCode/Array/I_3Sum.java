package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// https://leetcode.com/problems/3sum/
public class I_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int standard = 0; standard < n - 2; standard++) {
            int left = standard + 1;
            int right = n - 1;

            if (standard > 0 && nums[standard] == nums[standard - 1]) {
                continue;
            }

            while (left < right) {
                int total = nums[standard] + nums[left] + nums[right];
                if (total == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[standard]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    answer.add(temp);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (total > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        I_3Sum solution = new I_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> temp : result) {
            System.out.println(temp);
        }
    }
}
