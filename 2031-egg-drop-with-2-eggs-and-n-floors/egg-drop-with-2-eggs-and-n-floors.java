class Solution {
    public int twoEggDrop(int n) {
        return minCountToFindThresholdFloor(2,n);
    }

    public int minCountToFindThresholdFloor(int e,int f) {
        int[][] dp = new int[e+1][f+1];

        for (int i = 0; i <= e; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(dp,e,f);
    }

    private int helper(int[][] dp, int e, int f) {
        if (e == 1 || f == 0 || f == 1) {
            return f;
        }

        if (dp[e][f] != -1) {
            return dp[e][f];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++) {
            int low,high;

            if (dp[e-1][i-1] != -1) {
                low = dp[e-1][i-1];
            } else {
                low = helper(dp, e-1, i-1);
            }

            if (dp[e][f-i] != -1) {
                high = dp[e][f-i];
            } else {
                high = helper(dp, e, f-i);
            }

            int temp = 1 + Math.max(low, high);

            min = Math.min(min, temp);

            dp[e][f] = min;
        }
        return min;
    }
}