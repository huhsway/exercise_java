package LeetCode.Matrix;

public class RotateImage {

    private static void rotate(int[][] matrix) {
        reverseMatrix(matrix);
        transposeMatrix(matrix);
        printMatrix(matrix); // Optional: print the result
    }

    private static void reverseMatrix(int[][] matrix) {
        int start = 0, end = matrix.length - 1;

        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;

            start++;
            end--;
        }
    }

    private static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        System.out.println("\nRotated Matrix:");
        rotate(matrix);
    }
}

