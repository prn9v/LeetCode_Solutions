class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(dp, 0, nums);
    }

    private int helper(int[] dp, int idx, int[] nums) {

        if (idx >= nums.length - 1) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[idx] && idx + i < nums.length; i++) {
            int res = helper(dp,idx + i, nums);

            if (res != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + res);
            }
        }

        return dp[idx] = ans;
    }
}