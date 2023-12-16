package dfs;

import java.util.Scanner;

public class DfsApplication {

    private static int n, m;
    private static int[][] graph;

    public static boolean dfs(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= m) {
            return false;
        }

        if (graph[y][x] == 0) {
            graph[y][x] = 1;
            dfs(y - 1, x);
            dfs(y, x - 1);
            dfs(y + 1, x);
            dfs(y, x + 1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
