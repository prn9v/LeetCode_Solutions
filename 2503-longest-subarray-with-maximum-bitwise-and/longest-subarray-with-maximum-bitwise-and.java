class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);  // Find the maximum value
        }

        int maxLen = 0;
        int currentLen = 0;

        for (int num : nums) {
            if (num == maxVal) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 0;  // Reset streak if not maxVal
            }
        }

        return maxLen;
    }
}