package dfs;

import java.util.*;

public class Dfs {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>(Arrays.asList(
                Collections.emptyList(),
                Arrays.asList(2, 3, 8),
                Arrays.asList(1, 7),
                Arrays.asList(1, 4, 5),
                Arrays.asList(3, 5),
                Arrays.asList(3, 4),
                Arrays.asList(7),
                Arrays.asList(2, 6, 8),
                Arrays.asList(1, 7)
        ));

        boolean[] visited = new boolean[graph.size()];

        dfs(graph, visited, 1);

    }

    private static void dfs(List<List<Integer>> graph, boolean[] visited, int v) {

        visited[v] = true;
        System.out.println(v);

        for (int i : graph.get(v)) {
            if (!visited[i]) {
                dfs(graph, visited, i);
            }
        }

    }

}
