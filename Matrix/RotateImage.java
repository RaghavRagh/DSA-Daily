// 48
// https://leetcode.com/problems/rotate-image/description/

public class RotateImage {

    private static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // transpose
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                swap(matrix, i, j);
            }
        }

        // reverse row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        PrintArray p = new PrintArray();
        p.print(matrix);

        rotate(matrix);
        System.out.println();

        p.print(matrix);
        
    }
}
