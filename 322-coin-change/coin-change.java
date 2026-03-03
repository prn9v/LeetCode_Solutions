class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1; 
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {

                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(
                        1 + dp[i][j - coins[i - 1]],
                        dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        if(dp[m][amount] >= Integer.MAX_VALUE - 1){
            return -1;
        }

        return dp[m][amount];
    }
}