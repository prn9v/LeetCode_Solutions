class Solution {
    static final int MOD = 1_000_000_007;
    
    public int numberOfWays(int n, int x) {
        List<Integer> powersList = new ArrayList<>();
        int base = 1;
        while (true) {
            long val = (long) Math.pow(base, x);
            if (val > n) break;
            powersList.add((int) val);
            base++;
        }

        int m = powersList.size();
        int[] powers = new int[m];
        for (int i = 0; i < m; i++) powers[i] = powersList.get(i);

        // Step 2: DP table [m+1][n+1]
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Step 3: Fill table backwards over index
        for (int idx = m - 1; idx >= 0; idx--) {
            for (int target = 1; target <= n; target++) {
                dp[idx][target] = dp[idx + 1][target];
                if (target >= powers[idx]) {
                    dp[idx][target] = (dp[idx][target] + dp[idx + 1][target - powers[idx]]) % MOD;
                }
            }
        }

        return dp[0][n];
    }
}