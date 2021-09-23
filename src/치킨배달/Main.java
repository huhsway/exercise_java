package 치킨배달;

import java.util.*;

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] arr = new int[50][50];
    public static ArrayList<Position> chicken = new ArrayList<>();
    public static ArrayList<Position> house = new ArrayList<>();

    public static int getSum(ArrayList<Position> candidates) {
        int result = 0;
        // 모든 집에 대하여
        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).getX();
            int hy = house.get(i).getY();
            // 가장 가까운 치킨 집을 찾기
            int temp = (int) 1e9;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).getX();
                int cy = candidates.get(j).getY();
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            // 가장 가까운 치킨 집까지의 거리를 더하기
            result += temp;
        }
        // 치킨 거리의 합 반환
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                arr[r][c] = sc.nextInt();
                if (arr[r][c] == 1) house.add(new Position(r, c)); // 일반 집
                else if (arr[r][c] == 2) chicken.add(new Position(r, c)); // 치킨집
            }
        }

        // 모든 치킨 집 중에서 m개의 치킨 집을 뽑는 조합 계산
        ArrayList<ArrayList<Position>> chickenList = new ArrayList<ArrayList<Position>>();
        int[] comArr = new int[m];
        Combination(chicken.size(), m, comArr, 0, 0, chicken, chickenList);

        // 치킨 거리의 합의 최소를 찾아 출력
        int result = (int) 1e9;
        for (int i = 0; i < chickenList.size(); i++) {
            result = Math.min(result, getSum(chickenList.get(i)));
        }
        System.out.println(result);
    }

    public static void Combination(int n, int r, int[] comArr, int index, int target, ArrayList<Position> chicken, ArrayList<ArrayList<Position>> chickenList) {

        if (r == 0) {
            ArrayList<Position> temp = new ArrayList<Position>();
            for (int i = 0; i < comArr.length; i++) {
                temp.add(chicken.get(comArr[i]));
            }
            chickenList.add(temp);
            return;
        }

        if (target == n) return;

        comArr[index] = target;
        Combination(n, r-1, comArr, index + 1, target + 1, chicken, chickenList);
        Combination(n, r, comArr, index, target + 1, chicken, chickenList);

    }

}
