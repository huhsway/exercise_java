package 화성탐사;

import java.util.*;

class Node implements Comparable<Node> {

    private int y;
    private int x;
    private int distance;

    public Node(int y, int x, int distance) {
        this.y = y;
        this.x = x;
        this.distance = distance;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getDistance() {
        return this.distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class Main {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    public static int[][] graph = new int [125][125];
    public static int[][] d = new int[125][125];
    public static int testCase, n;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {-1, 0, 1, 0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        // 전체 테스트 케이스(Test Case)만큼 반복
        for (int tc = 0; tc < testCase; tc++) {
            // 노드의 개수를 입력받기
            n = sc.nextInt();

            // 전체 맵 정보를 입력받기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            // 최단 거리 테이블을 모두 무한으로 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(d[i], INF);
            }

            int y = 0, x = 0; // 시작 위치는 (0, 0)
            // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, graph[y][x]));
            d[y][x] = graph[y][x];

            while(!pq.isEmpty()) { // 다익스트라 알고리즘을 수행
                // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
                Node node = pq.poll();
                int dist = node.getDistance();
                y = node.getY();
                x = node.getX();
                // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
                if (d[y][x] < dist) continue;
                // 현재 노드와 연결된 다른 인접한 노드들을 확인
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    // 맵의 범위를 벗어나는 경우 무시
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    int cost = dist + graph[ny][nx];
                    // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                    if (cost < d[ny][nx]) {
                        d[ny][nx] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
            System.out.println(d[n - 1][n - 1]);
        }
    }
}