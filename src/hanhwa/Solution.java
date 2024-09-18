package hanhwa;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public long solution(int[] heights) {
        int n = heights.length;
        long count = 0;

        // 왼쪽에서 오른쪽으로 볼 수 있는 건물 수
        count += countVisibleBuildings(heights);

        // 오른쪽에서 왼쪽으로 볼 수 있는 건물 수
        int[] reversedHeights = new int[n];
        for (int i = 0; i < n; i++) {
            reversedHeights[i] = heights[n - 1 - i];
        }
        count += countVisibleBuildings(reversedHeights);

        return count;
    }

    private long countVisibleBuildings(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        long count = 0;

        for (int height : heights) {
            // 스택에 현재 건물보다 낮은 건물들을 제거하여 현재 건물이 볼 수 없는 건물들을 제거
            while (!stack.isEmpty() && stack.peek() < height) {
                stack.pop();
            }

            // 스택에 있는 건물의 수를 카운트 (같은 높이도 하나로 보고 뒤에 더 높은 것도 고려)
            count += stack.size();

            // 현재 건물을 스택에 추가
            // 같은 높이의 건물이 있으면 스택에 추가하지 않음 (같은 높이 하나로 본다)
            if (stack.isEmpty() || stack.peek() != height) {
                stack.push(height);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스
        int[] heights1 = {1, 4, 2, 5, 3};
        int[] heights2 = {3, 4, 5, 6, 7};
        int[] heights3 = {5, 5, 5};
        int[] heights4 = {1, 99998, 99999};
        int[] heights5 = {3, 5, 4, 2, 4, 4, 6, 5};

        System.out.println(solution.solution(heights1)); // 출력: 6
        System.out.println(solution.solution(heights2)); // 출력: 10
        System.out.println(solution.solution(heights3)); // 출력: 4
        System.out.println(solution.solution(heights4)); // 출력: 3
        System.out.println(solution.solution(heights5)); // 출력: 18
    }
}
