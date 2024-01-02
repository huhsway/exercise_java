package 치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] city;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    house.add(new int[]{i, j});
                } else if (city[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        List<List<int[]>> candidates = getCombination(chicken.size(), m, chicken);
        int answer = Integer.MAX_VALUE;
        for (List<int[]> candidate : candidates) {
            answer = Math.min(answer, getMinDistance(house, candidate));
        }

        System.out.println(answer);
    }

    static int getMinDistance(List<int[]> house, List<int[]> candidate) {
        int sum = 0;
        for (int[] h : house) {
            int min = Integer.MAX_VALUE;
            for (int[] c : candidate) {
                int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                min = Math.min(min, distance);
            }
            sum += min;
        }
        return sum;
    }

    static List<List<int[]>> getCombination(int n, int m, List<int[]> arr) {
        List<List<int[]>> result = new ArrayList<>();
        int[] temp = new int[m];

        dfs(result, arr, temp, 0, 0, n, m);

        return result;
    }

    static void dfs(List<List<int[]>> result, List<int[]> arr, int[] temp, int depth, int start, int n, int m) {
        if (depth == m) {
            List<int[]> combination = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                combination.add(arr.get(temp[i]));
            }
            result.add(combination);
            return;
        }

        for (int i = start; i < n; i++) {
            temp[depth] = i;
            dfs(result, arr, temp, depth + 1, i + 1, n, m);
        }
    }
}
