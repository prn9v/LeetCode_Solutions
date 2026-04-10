class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] != nums[j]) continue;
                for (int k = j +1; k < n; k++) {
                    if(nums[i] == nums[j] && nums[j] == nums[k]){
                        int d = Math.abs(i-j) + Math.abs(j - k) + Math.abs(k - i);
                        min = Integer.min(min,d);
                        break;
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }
}