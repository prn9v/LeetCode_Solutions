class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for(int num:nums){
            ans = ans | num;
        }

        int count = 0;
        int totalSubsets = 1 << n; 

        for (int i = 0; i < totalSubsets; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum = sum | nums[j];
                }
            }
            if(sum == ans){
                count++;
            }
        }
        return count;
    }
}