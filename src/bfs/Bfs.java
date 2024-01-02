package bfs;

import java.util.*;

public class Bfs {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>()); // 더미 노드

        // 그래프 생성
        graph.add(List.of(2, 3, 8));
        graph.add(List.of(1, 7));
        graph.add(List.of(1, 4, 5));
        graph.add(List.of(3, 5));
        graph.add(List.of(3, 4));
        graph.add(List.of(7));
        graph.add(List.of(2, 6, 8));
        graph.add(List.of(1, 7));

        boolean[] visited = new boolean[9];

        bfs(graph, 1, visited);
    }

    public static void bfs(List<List<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int i : graph.get(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
