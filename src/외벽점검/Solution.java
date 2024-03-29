package 외벽점검;

import java.util.*;

class Solution {
    public int solution(int n, int[] weak, int[] dist) {
        // 길이를 2배로 늘려서 '원형'을 일자 형태로 변경
        List<Integer> weakList = new ArrayList<>();
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i]);
        }
        for (int i = 0; i < weak.length; i++) {
            weakList.add(weak[i] + n);
        }
        // 투입할 친구 수의 최솟값을 찾아야 하므로 len(dist) + 1로 초기화
        int answer = dist.length + 1;

        // 친구 정보를 이용해 모든 순열 계산
        List<List<Integer>> distList = getPermutation(dist.length, dist.length, dist);

        // 0부터 length - 1까지의 위치를 각각 시작점으로 설정
        for (int start = 0; start < weak.length; start++) {
            // 친구를 나열하는 모든 경우 각각에 대하여 확인
            for (int i = 0; i < distList.size(); i++) {
                int cnt = 1; // 투입할 친구의 수
                // 해당 친구가 점검할 수 있는 마지막 위치
                int position = weakList.get(start) + distList.get(i).get(cnt - 1);
                // 시작점부터 모든 취약한 지점을 확인
                for (int index = start; index < start + weak.length; index++) {
                    // 점검할 수 있는 위치를 벗어나는 경우
                    if (position < weakList.get(index)) {
                        cnt += 1; // 새로운 친구를 투입
                        if (cnt > dist.length) { // 더 투입이 불가능하다면 종료
                            break;
                        }
                        position = weakList.get(index) + distList.get(i).get(cnt - 1);
                    }
                }
                answer = Math.min(answer, cnt); // 최솟값 계산
            }
        }
        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }

    public List<List<Integer>>  getPermutation(int n, int m, int[] dist) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[n];

        dfs(n, m, dist, 0, visited, temp, result);

        return result;
    }

    public static void dfs(int n, int m, int[] dist, int depth, boolean[] visited, List<Integer> temp, List<List<Integer>> result) {

        if (depth == m){
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp.add(dist[i]);
                    dfs(n, m, dist, depth + 1, visited, temp, result);
                    temp.remove(temp.size() - 1);
                    visited[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1,5,6,10};
        int[] dist = {1,2,3,4};
        Solution sol = new Solution();
        System.out.println(sol.solution(n,weak,dist));
    }
}
