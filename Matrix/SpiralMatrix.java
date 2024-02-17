import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> list = new ArrayList<>();

        int count = 0;
        int total = row * col;

        int startRow = 0;
        int startCol = 0;
        int endRow = row - 1;
        int endCol = col - 1;

        while (count < total) {
            // print starting row
            for (int i = startCol; i <= endCol && count < total; i++) {
                list.add(matrix[startRow][i]);
                count++;
            }
            startRow++;

            // print ending column
            for (int i = startRow; i <= endRow && count < total; i++) {
                list.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

            // print ending row
            for (int i = endCol; i >= startCol && count < total; i--) {
                list.add(matrix[endRow][i]);
                count++;
            }
            endRow--;

            // print starting column
            for (int i = endRow; i >= startRow && count < total; i--) {
                list.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        List<Integer> list = new ArrayList<>();

        list = spiralOrder(matrix);
        System.out.println(list);
    }
}
