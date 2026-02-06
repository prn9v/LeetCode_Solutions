class Solution {
    public int minRemoval(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);

        int i = 0;
        int maxWindow = 1;

        for (int j = 0; j < nums.length; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxWindow = Math.max(maxWindow, j - i + 1);
        }

        return nums.length - maxWindow;
    }
}