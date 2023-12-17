package dfs;

import java.util.Scanner;

// https://yganalyst.github.io/training/algo_tr_ect_1/

public class DfsApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();

        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
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

    private static boolean dfs(int y, int x, int[][] graph) {

        if (y < 0 || y >= graph.length || x < 0 || x >= graph[0].length) {
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

}
