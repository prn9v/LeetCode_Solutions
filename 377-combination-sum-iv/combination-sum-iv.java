class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return helper(dp, nums, target);
    }

    private int helper(Integer[] dp, int[] nums, int target) {
        
        if (target == 0) {
            return 1;
        }

        if (dp[target] != null) {
            return dp[target];
        }

        int count = 0;

        for (int num : nums) {
            if (target - num >= 0) {
                count += helper(dp, nums, target- num);
            }
        }

        return dp[target] = count;
    }
}