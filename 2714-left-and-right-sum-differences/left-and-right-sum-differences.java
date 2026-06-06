class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }
         return ans;
    }
}