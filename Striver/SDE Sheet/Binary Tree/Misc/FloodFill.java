public class FloodFill {

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int originalColor = image[sr][sc];

        if (originalColor != color) {
            solve(image, sr, sc, originalColor, color, row, col);
        }

        return image;
    }

    private static void solve(int[][] image, int sr, int sc, int originalColor, int color, int row, int col) {
        if (sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != originalColor ) {
            return;
        }

        image[sr][sc] = color;

        solve(image, sr - 1, sc, originalColor, color, row, col); //up
        solve(image, sr + 1, sc, originalColor, color, row, col); //down
        solve(image, sr, sc - 1, originalColor, color, row, col); //left
        solve(image, sr, sc + 1, originalColor, color, row, col); //right
    }
    
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        int[][] res = floodFill(image, sr, sc, color);
        for (int[] rows : res) {
            for (int i : rows) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
