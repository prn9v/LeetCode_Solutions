class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;

        int i = 0;
        int j = k-1;

        while (j < nums.length) {
            int max =Integer.MIN_VALUE;
            int min =Integer.MAX_VALUE;

            for (int l = i; l <= j; l++) {
                max = Math.max(max, nums[l]);
                min = Math.min(min, nums[l]);
            }

            minDiff = Math.min(minDiff, max - min);
            i++;
            j++;
        }

        return minDiff;
    }
}