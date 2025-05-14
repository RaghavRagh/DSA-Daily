import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens_NsqTC {

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        dfs(0, board, ans); 
        return ans;
    }

    static void dfs(int col, char[][] board, List<List<String>> ans) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    //TC - O(n^2)
    // it is checking n times is queen present at particular position 
    private static boolean isSafe(char[][] board, int row, int col) {
        // check upper diagonal
        int duprow = row;
        int dupcol = col;

        // upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row--][col--] == 'Q') {
                return false;
            }
        }

        col = dupcol;
        row = duprow;

        // left
        while (col >= 0) {
            if (board[row][col--] =='Q') {
                return false;
            }
        }

        row = duprow;
        col = dupcol;

        // lower diagnonal
        while (row < board.length && col >= 0) {
            if (board[row++][col--] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }

        return res;
    }
    
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> ans = solveNQueens(n);
        ans.forEach(System.out::println);
    }
}