import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    static class Pair {
        int row, col, time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    private static int orangesRotting1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int time = 0;
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        int count = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(time, t);

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = r + drow[i]; // neighbouringRow
                int nCol = c + dcol[i]; // neighbouringCol

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] != 2 && grid[nRow][nCol] == 1) {
                    q.add(new Pair(nRow, nCol, t + 1));
                    vis[nRow][nCol] = 2;
                    count++;
                }
            }
        }

        if (count != countFresh) {
            return -1;
        }

        return time;
    }

    // another way
    static class PairB {
        int i;
        int j;

        PairB(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int orangesRotting2(int[][] grid) {
        Queue<PairB> q = new LinkedList<>();
        int m = grid[0].length;
        int n = grid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new PairB(i, j));
                }
            }
        }
        q.offer(new PairB(-1, -1));

        while (!q.isEmpty()) {
            PairB node = q.poll();
            if (node.i == -1 && node.j == -1) {
                if (q.isEmpty())
                    continue;
                q.offer(new PairB(-1, -1));
                count++;
                continue;
            }

            int i = node.i;
            int j = node.j;

            if (i > 0 && grid[i - 1][j] == 1) {
                q.offer(new PairB(i - 1, j));
                grid[i - 1][j] = 2;
            }

            if (i < n - 1 && grid[i + 1][j] == 1) {
                q.offer(new PairB(i + 1, j));
                grid[i + 1][j] = 2;
            }

            if (j > 0 && grid[i][j - 1] == 1) {
                q.offer(new PairB(i, j - 1));
                grid[i][j - 1] = 2;
            }

            if (j < m - 1 && grid[i][j + 1] == 1) {
                q.offer(new PairB(i, j + 1));
                grid[i][j + 1] = 2;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting1(grid));
        System.out.println(orangesRotting2(grid));
    }
}
