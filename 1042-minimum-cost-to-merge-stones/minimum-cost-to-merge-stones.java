class Solution {

    private int[][][] dp;
    private int[] prefix;
    private int K;
    private static final int INF = (int)1e9;

    public int mergeStones(int[] stones, int k) {

        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }

        this.K = k;
        dp = new int[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p <= k; p++) {
                    dp[i][j][p] = -1;
                }
            }
        }
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        return dfs(0, n - 1, 1);
    }

    private int dfs(int i, int j, int piles) {

        int len = j - i + 1;

        if ((len - piles) % (K - 1) != 0) {
            return INF;
        }

        if (i == j) {
            return piles == 1 ? 0 : INF;
        }

        if (dp[i][j][piles] != -1) {
            return dp[i][j][piles];
        }

        int ans = INF;

        if (piles == 1) {

            int costToMakeKpiles = dfs(i, j, K);

            if (costToMakeKpiles == INF) {
                return dp[i][j][piles] = INF;
            }

            int totalSum = rangeSum(i, j);

            ans = costToMakeKpiles + totalSum;
        }
        else {

            for (int mid = i; mid < j; mid += (K - 1)) {

                int leftCost = dfs(i, mid, 1);

                int rightCost = dfs(mid + 1, j, piles - 1);

                ans = Math.min(ans, leftCost + rightCost);
            }
        }

        return dp[i][j][piles] = ans;
    }
    
    private int rangeSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}