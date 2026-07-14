class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        int ans = helper(coins, amount, 0, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int[] coins, int amount, int idx, Integer[][] dp) {
        if (amount == 0)
            return 0;

        if (idx == coins.length)
            return Integer.MAX_VALUE;

        if (dp[idx][amount] != null)
            return dp[idx][amount];

        int ans = Integer.MAX_VALUE;

        for(int i = idx; i < coins.length; i++) {
            if (amount >= coins[i]) {
                int res = helper(coins, amount - coins[i], i, dp);
                if (res != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + res);
                }
            }
        }

        return dp[idx][amount] = ans;
    }
}