class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[] dp = new Integer[stoneValue.length+1];
        int ans = helper(stoneValue,0,dp);
        if(ans > 0) {
            return "Alice";
        }

        if(ans < 0) {
            return "Bob";
        }

        return "Tie";
    }

    private int helper(int[] stoneValue, int i, Integer[] dp) {
        if (i >= stoneValue.length)
            return 0;

        if(dp[i] != null) {
            return dp[i];
        }

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            sum += stoneValue[i + k];
            ans = Math.max(ans, sum - helper(stoneValue, i + k + 1, dp));
        }

        return dp[i] = ans;
    }
}