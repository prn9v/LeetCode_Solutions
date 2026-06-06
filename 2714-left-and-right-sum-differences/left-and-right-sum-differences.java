class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int leftCal = 0;
        int rightCal = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum[i] = leftCal;
            leftCal = leftCal + nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum[i] = rightCal;
            rightCal = rightCal + nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}