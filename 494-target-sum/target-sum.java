class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        int zeroCount = 0;

        for (int num : nums) {
            totalSum += num;
            if (num == 0) zeroCount++;
        }

        if (totalSum < Math.abs(target) || (target + totalSum) % 2 != 0) {
            return 0;
        }

        int p = (target + totalSum) / 2;

        int[][] dp = new int[nums.length + 1][p + 1];

        dp[0][0] = 1;   // only this

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= p; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][p];
    }
}