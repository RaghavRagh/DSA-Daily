public class Convert1Dto2D {

    private static int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        
        int[][] arr = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[k++];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] original = { 3 };
        int[][] res = construct2DArray(original, 1, 2);
        for (int[] is : res) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
