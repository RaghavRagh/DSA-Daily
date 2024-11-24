public class MaxMatrixSum {

    private static long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsVal = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                totalSum += Math.abs(val);
                if (val < 0) negativeCount++;
                minAbsVal = Math.min(Math.abs(val), minAbsVal);
            }
        }

        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsVal;
        }

        return totalSum;
    }
    
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 1, 2, -3 }, { 1, 2, 3 } };
        System.out.println(maxMatrixSum(matrix));
    }
}
