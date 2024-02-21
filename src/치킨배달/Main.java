package 치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    private int y;
    private int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

public class Main {

    private static int n, m;
    private static int[][] city;
    private static List<Node> house = new ArrayList<>();
    private static List<Node> chicken = new ArrayList<>();

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
                    house.add(new Node(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        List<List<Node>> candidates = getCombination(chicken.size(), m, chicken);
        int answer = Integer.MAX_VALUE;
        for (List<Node> candidate : candidates) {
            answer = Math.min(answer, getMinDistance(house, candidate));
        }

        System.out.println(answer);
    }

    private static int getMinDistance(List<Node> house, List<Node> candidate) {
        int sum = 0;
        for (Node h : house) {
            int min = Integer.MAX_VALUE;
            for (Node c : candidate) {
                int distance = Math.abs(h.getY() - c.getY()) + Math.abs(h.getX() - c.getX());
                min = Math.min(min, distance);
            }
            sum += min;
        }
        return sum;
    }

    private static List<List<Node>> getCombination(int n, int m, List<Node> arr) {
        List<List<Node>> result = new ArrayList<>();
        List<Node> temp = new ArrayList<>();

        dfs(n, m, arr, 0, 0, temp, result);

        return result;
    }

    private static void dfs(int n, int m, List<Node> arr, int depth, int start, List<Node> temp, List<List<Node>> result) {
        if (depth == m) {
//            result.add(temp); // 얕은 복사 temp 리스트의 참조가 그대로 리스트에 추가되서 temp가 변경될 때마다 result 리스트의 항목도 변경됨
            result.add(new ArrayList<>(temp)); // 깊은 복사 temp 리스트의 요소들을 새로운 ArrayList 객체에 복사헤서 temp와 result가 독립적으로 유지
        } else {
            for (int i = start; i < n; i++) {
                temp.add(arr.get(i));
                dfs(n, m, arr, depth + 1, i + 1, temp, result);
                temp.remove(temp.size() - 1); // backtrack
            }
        }
    }
}

