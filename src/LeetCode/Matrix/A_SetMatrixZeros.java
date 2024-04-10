package LeetCode.Matrix;

public class A_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        // 행과 열의 길이를 저장
        int m = matrix.length;
        int n = matrix[0].length;

        // 각 행과 열에 0이 포함되어 있는지 여부를 저장하기 위한 배열
        boolean[] rowZero = new boolean[m];
        boolean[] colZero = new boolean[n];

        // 0이 있는 위치를 찾아서 해당 행과 열에 대한 정보를 저장
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        // 행에 0이 있으면 해당 행 전체를 0으로 설정
        for (int i = 0; i < m; i++) {
            if (rowZero[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 열에 0이 있으면 해당 열 전체를 0으로 설정
        for (int j = 0; j < n; j++) {
            if (colZero[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


//public class SetMatrixZeros {
//    public void setZeroes(int[][] matrix) {
//        List<int[]> points = new ArrayList<>();
//
//        // 2차원 배열을 순회하며 0의 위치를 찾아 저장
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (matrix[i][j] == 0) {
//                    points.add(new int[]{i, j});
//                }
//            }
//        }
//
//        // 0의 위치마다 해당 행과 열을 0으로 설정
//        for (int[] point : points) {
//            int i = point[0];
//            int j = point[1];
//
//            int up = 0;
//            int down = i + 1;
//            int left = 0;
//            int right = j + 1;
//
//            while (up < i) {
//                matrix[up][j] = 0;
//                up++;
//            }
//            while (down < matrix.length) {
//                matrix[down][j] = 0;
//                down++;
//            }
//            while (left < j) {
//                matrix[i][left] = 0;
//                left++;
//            }
//            while (right < matrix[i].length) {
//                matrix[i][right] = 0;
//                right++;
//            }
//        }
//    }
//}

