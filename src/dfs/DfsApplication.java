package dfs;

import java.io.*;
import java.util.*;

// https://yganalyst.github.io/training/algo_tr_ect_1/

public class DfsApplication {

    private static class Position {
        int y, x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int n, m;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static boolean dfs(int y, int x, int[][] graph) {

        if (y < 0 || y >= n || x < 0 || x >= m) {
            return false;
        }

        if (graph[y][x] == 0) {
            graph[y][x] = 1;
            dfs(y - 1, x, graph);
            dfs(y, x - 1, graph);
            dfs(y + 1, x, graph);
            dfs(y, x + 1, graph);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, graph)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
