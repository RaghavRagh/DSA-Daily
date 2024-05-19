import java.util.ArrayList;

public class RatInAMaze {

    private static ArrayList<String> findPath(int[][] maze, int n, int m) {
        ArrayList<String> ans = new ArrayList<>();
        if (maze[0][0] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][m];
        String path = "";
        solve(0, 0, maze, visited, path, ans, n, m);
        return ans;
    }

    private static void solve(int i, int j, int[][] maze, boolean[][] visited, String path, ArrayList<String> ans,
            int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {
            ans.add(path);
            return;
        }

        visited[i][j] = true;

        // Down
        if (isSafe(maze, visited, i + 1, j, n, m)) {
            solve(i + 1, j, maze, visited, path + 'D', ans, n, m);
        }

        // right
        if (isSafe(maze, visited, i, j + 1, n, m)) {
            solve(i, j + 1, maze, visited, path + 'R', ans, n, m);
        }

        // left
        if (isSafe(maze, visited, i, j - 1, n, m)) {
            solve(i, j - 1, maze, visited, path + 'L', ans, n, m);
        }

        // up
        if (isSafe(maze, visited, i - 1, j, n, m)) {
            solve(i - 1, j, maze, visited, path + 'U', ans, n, m);
        }

        // backtrack
        visited[i][j] = false;
    }

    private static boolean isSafe(int[][] maze, boolean[][] visited, int i, int j, int n, int m) {
        return ((i >= 0 && i < n) && (j >= 0 && j < m) && maze[i][j] == 1 && !visited[i][j]);
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 1, 1 },
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 },

                // { 1, 1, 1, 1 },
                // { 1, 1, 1, 1 },
                // { 1, 1, 1, 1 },
                // { 1, 1, 1, 1 },
                // { 0, 0, 0, 1 }
        };
        int n = maze.length;
        int m = maze[0].length;
        ArrayList<String> ans = findPath(maze, n, m);
        System.out.println(ans);
    }
}
