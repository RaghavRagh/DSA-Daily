public class SpiralMatrix {

    private static void printSpiral(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        int count = 0;
        int total = m * n;

        while (count < total) {
            for (int i = colStart; i <= colEnd && count < total; i++) {
                System.out.print(matrix[rowStart][i] + " ");
                count++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd && count < total; i++) {
                System.out.print(matrix[i][colEnd] + " ");
                count++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart && count < total; i--) {
                System.out.print(matrix[rowEnd][i] + " ");
                count++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart && count < total; i--) {
                System.out.print(matrix[i][colStart] + " ");
                count++;
            }
            colStart++;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 }
        };

        printSpiral(matrix);
    }
}
