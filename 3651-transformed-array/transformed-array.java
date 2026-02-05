class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num != 0) {
                int idx = ((i + num) % n + n) % n;
                result[i] = nums[idx];
            } else {
                result[i] = nums[i];
            }
        }

        return result;
    }
}