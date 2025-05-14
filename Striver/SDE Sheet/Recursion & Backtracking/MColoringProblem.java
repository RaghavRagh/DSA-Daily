public class MColoringProblem {

    private static boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        if (!solve(graph, m, color, 0)) {
            return false;
        }

        return true;
    }

    private static boolean solve(boolean[][] graph, int m, int[] color, int v) {
        if (v == color.length) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, color, v, c)) {
                color[v] = c;

                if (solve(graph, m, color, v + 1)) {
                    return true;
                }

                color[v] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(boolean[][] graph, int[] color, int v, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] && c == color[i]) {
                return false;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        int n = 4; // no. of vertices
        int m = 3; // no. of colors
        // int e = 5;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 }, { 0, 2 } };

        boolean[][] graph = new boolean[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = true;
            graph[v][u] = true;
        }

        if (graphColoring(graph, m, n)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
