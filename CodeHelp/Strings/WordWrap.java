import java.util.Arrays;

public class WordWrap {

    private static int solveWordWrap(int[] arr, int k) {
        int n = arr.length;

        // step 1: cal extra spaces
        int[][] extra = new int[n][n];
        for (int i = 0; i < n; i++) {
            extra[i][i] = k - arr[i];
            for (int j = i + 1; j < n; j++) {
                extra[i][j] = extra[i][j - 1] - arr[j] - 1;
            }
        }

        // compute cost
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (extra[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    cost[i][j] = (j == n - 1) ? 0 : extra[i][j] * extra[i][j];
                }
            }
        }

        // compute dp array
        int[] dp = new int[n];
        int[] breakPoint = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] != Integer.MAX_VALUE) {
                    int currentCost = cost[i][j] + ((j + 1 < n) ? dp[j + 1] : 0);
                    if (currentCost < dp[i]) {
                        dp[i] = currentCost;
                        breakPoint[i] = j + 1;
                    }
                }
            }
        }

        // Step 4: Print the lines
        int i = 0;
        while (i < n) {
            System.out.println("Line: " + (i + 1) + " -> Words " + (i + 1) + " to " + breakPoint[i]);
            i = breakPoint[i];
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 2, 5 };
        System.out.println(solveWordWrap(arr, 6));
    }
}
