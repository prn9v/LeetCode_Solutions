class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;   // should be long, not int (to avoid overflow for large input)
        long count = 0;
        boolean isSubArray = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !isSubArray) {
                isSubArray = true;
                count = 1;
            } else if (nums[i] == 0 && isSubArray) {
                count++;
            } else {
                ans += (count * (count + 1)) / 2;
                count = 0;
                isSubArray = false;
            }
        }

        // Add last zero-subarray contribution
        ans += (count * (count + 1)) / 2;

        return ans;
    }
}
