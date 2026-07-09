class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int sum = nums[0];
        max = Math.max(max,sum);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > sum + nums[i]) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max,sum);
        }

        return max;
    }
}