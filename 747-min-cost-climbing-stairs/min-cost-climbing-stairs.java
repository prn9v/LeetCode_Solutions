class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(dp,0, cost), helper(dp,1, cost));
    }

    private int helper(int[] dp, int idx, int[] cost) {
        if (idx >= cost.length) {
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int oneStep = helper(dp,idx + 1, cost);
        int twoStep = helper(dp,idx + 2, cost);

        dp[idx] = cost[idx] + Math.min(oneStep, twoStep); 
        return dp[idx];
    }
}