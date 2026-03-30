class Solution {
    public int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return helper(nums, 0, dp);
    }

    private int helper(int[] nums, int idx, Integer[] dp) {
        if (idx >= nums.length) return 0;

        if (dp[idx] != null) return dp[idx];

        int rob = nums[idx] + helper(nums, idx + 2, dp);
        int skip = helper(nums, idx + 1, dp);

        return dp[idx] = Math.max(rob, skip);
    }
}