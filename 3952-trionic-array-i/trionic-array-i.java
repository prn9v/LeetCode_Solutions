class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length <= 3){
            return false;
        }

        if(nums[1] < nums[0]) {
            return false;
        }
        int stage = 1;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] == nums[i]){
                return false;
            }

            if(stage == 1 && nums[i+1] < nums[i]) {
                stage = 2;
            }

            if(stage == 2 && nums[i+1] > nums[i]) {
                stage = 3;
            }

            if(stage == 3 && nums[i+1] <= nums[i]) {
                stage = 4;
            } 

        }

        if(stage == 3){
            return true;
        } else {
            return false;
        }
    }
}