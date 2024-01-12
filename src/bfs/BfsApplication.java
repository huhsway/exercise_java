package bfs;

import java.io.*;
import java.util.*;

// https://yganalyst.github.io/training/algo_tr_ect_2/

public class BfsApplication {

    private static class Position {
        int y, x;

        Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int[][] graph;
    private static int n, m;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int bfs(int y, int x) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            y = pos.y;
            x = pos.x;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m || graph[ny][nx] == 0) {
                    continue;
                }

                if (graph[ny][nx] == 1) {
                    graph[ny][nx] = graph[y][x] + 1;
                    queue.offer(new Position(ny, nx));
                }
            }
        }

        return graph[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

}