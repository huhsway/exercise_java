package LeetCode.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        List<int[]> points = new ArrayList<>();

        // 2차원 배열을 순회하며 0의 위치를 찾아 저장
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    points.add(new int[]{i, j});
                }
            }
        }

        // 0의 위치마다 해당 행과 열을 0으로 설정
        for (int[] point : points) {
            int i = point[0];
            int j = point[1];

            int up = 0;
            int down = i + 1;
            int left = 0;
            int right = j + 1;

            while (up < i) {
                matrix[up][j] = 0;
                up++;
            }
            while (down < matrix.length) {
                matrix[down][j] = 0;
                down++;
            }
            while (left < j) {
                matrix[i][left] = 0;
                left++;
            }
            while (right < matrix[i].length) {
                matrix[i][right] = 0;
                right++;
            }
        }
    }
}

