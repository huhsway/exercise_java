package 치킨배달;

import java.util.*;

public class Main {

    private static class Position {
        private int y;
        private int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return this.y;
        }

        public int getX() {
            return this.x;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        List<Position> chickens = new ArrayList<>();
        List<Position> houses = new ArrayList<>();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) houses.add(new Position(i, j));
                if (arr[i][j] == 2) chickens.add(new Position(i, j));
            }
        }

        List<Position> comArr = new ArrayList<>();
        List<List<Position>> candidates = new ArrayList<>();

        combination(chickens.size(), m, 0, 0, chickens, comArr, candidates);

        int result = (int) 1e9;
        for (List<Position> candidate : candidates) {
            result = Math.min(result, getSum(houses, candidate));
        }
        System.out.println(result);
    }

    public static void combination(int n, int r, int depth, int start, List<Position> arr, List<Position> comArr, List<List<Position>> candidates) {

        if (depth == r) {
            List<Position> temp = new ArrayList<>(comArr);
            candidates.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            comArr.add(arr.get(i)); // comArr에 요소 추가
            combination(n, r, depth + 1, i + 1, arr, comArr, candidates);
            comArr.remove(comArr.size() - 1); // 이전 요소를 제거하여 다음 요소를 추가할 수 있도록 합니다.
        }

    }

    public static int getSum(List<Position> houses, List<Position> candidate) {
        int result = 0;
        for (Position house : houses) {
            int hy = house.getY();
            int hx = house.getX();

            int temp = (int) 1e9;
            for (Position p : candidate) {
                int cy = p.getY();
                int cx = p.getX();
                temp = Math.min(temp, Math.abs(hy - cy) + Math.abs(hx - cx));
            }
            result += temp;
        }
        return result;
    }


}


