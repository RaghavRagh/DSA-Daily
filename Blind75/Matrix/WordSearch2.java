public class WordSearch2 {

    boolean visited[][];

    private boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (word.charAt(0) == board[i][j] && search(i, j, 0, word, board)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(int i, int j, int index, String word, char[][] board) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || word.charAt(index) != board[i][j]
                || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (search(i + 1, j, index + 1, word, board) ||
                search(i - 1, j, index + 1, word, board) ||
                search(i, j + 1, index + 1, word, board) ||
                search(i, j - 1, index + 1, word, board)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";

        WordSearch2 obj = new WordSearch2();

        boolean ans = obj.exist(board, word);
        System.out.println(ans);
    }
}
