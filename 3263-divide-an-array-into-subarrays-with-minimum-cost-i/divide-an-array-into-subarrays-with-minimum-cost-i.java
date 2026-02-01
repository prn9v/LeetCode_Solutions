class Solution {
    public int minimumCost(int[] nums) {
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];
        Arrays.sort(nums, 1, nums.length); 
        return nums[0] + nums[1] + nums[2];
    }
}