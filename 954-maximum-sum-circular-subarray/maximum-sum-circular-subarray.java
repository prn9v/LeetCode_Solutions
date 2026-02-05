class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int maxEnding = nums[0];
        int maxSoFar = nums[0];
        int minEnding = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            maxEnding = Math.max(x, maxEnding + x);
            maxSoFar = Math.max(maxSoFar, maxEnding);

            minEnding = Math.min(x, minEnding + x);
            minSoFar = Math.min(minSoFar, minEnding);

            totalSum += x;
        }

        if (maxSoFar < 0)
            return maxSoFar;

        return Math.max(maxSoFar, totalSum - minSoFar);
    }
}