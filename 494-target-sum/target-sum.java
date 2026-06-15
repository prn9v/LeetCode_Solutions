class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> dp = new HashMap<>();
        return helper(dp,nums,target,0,0);
    }

    private int helper(Map<String,Integer> dp, int[] nums, int target,int sum,int index) {
        if(index == nums.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        String key = sum + " " + index;
        
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int withMinus = helper(dp, nums, target, sum - nums[index], index + 1);
        int withPlus = helper(dp, nums, target, sum + nums[index], index + 1);

        int ans = withMinus + withPlus;

        dp.put(key,ans);
        return ans;
    }
}