class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;

        long[][] max_dp = new long[m][n];
        long[][] min_dp = new long[m][n];

        max_dp[0][0] = grid[0][0];
        min_dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            max_dp[0][j] = max_dp[0][j-1] * grid[0][j];
            min_dp[0][j] = max_dp[0][j];
        }

        for (int i = 1; i < m; i++) {
            max_dp[i][0] = max_dp[i-1][0] * grid[i][0];
            min_dp[i][0] = max_dp[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];

                long a = max_dp[i-1][j] * val;
                long b = min_dp[i-1][j] * val;
                long c = max_dp[i][j-1] * val;
                long d = min_dp[i][j-1] * val;

                max_dp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min_dp[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long res = max_dp[m-1][n-1];

        if (res < 0) return -1;
        return (int)(res % MOD);
    }
}