class Solution {
    public int minimumCost(int[] nums) {
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];

        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum < minSum){
                    minSum = sum;
                }
            }
        }

        return nums[0] + minSum;
    }
}