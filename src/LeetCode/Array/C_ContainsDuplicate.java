package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/contains-duplicate/
public class C_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

//        for (int count : countMap.values()) {
//            if (count != 1) {
//                return true;
//            }
//        }
//
//        return false;

        // anyMatch는 boolean형을 반환 만약 count 가 1보다 큰게 하나라도 있으면 true 반환 그렇지 않으면 false 반환
        return countMap.values().stream().anyMatch(count -> count > 1);

    }

    public static void main(String[] args) {
        C_ContainsDuplicate solution = new C_ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        boolean containsDup = solution.containsDuplicate(nums);
        System.out.println(containsDup);
    }
}

