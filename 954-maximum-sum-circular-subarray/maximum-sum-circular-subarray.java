class Solution {
     private int totalSum = 0;
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = kadane(nums,true);
        int minSum = kadane(nums,false);
        return maxSum > 0 ? Math.max(maxSum,totalSum - minSum) : maxSum;
    }

    public int kadane(int[] nums,boolean isMax){
        int sum = nums[0];
        int curr_sum = nums[0];
        totalSum = nums[0];
        for(int i=1;i<nums.length;i++){
            totalSum += nums[i];
            if(isMax){
                curr_sum = Math.max(nums[i],nums[i] + curr_sum);
                sum = Math.max(curr_sum,sum);
            }else{
                curr_sum = Math.min(nums[i],nums[i] + curr_sum);
                sum = Math.min(curr_sum,sum);
            }
        }
        return sum;
    }
}