class Solution {
    public int lengthOfLIS(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);

        int[] arr = set.stream()
               .sorted()        // O(n log n)
               .mapToInt(Integer::intValue)
               .toArray();

        int[][] dp = new int[nums.length + 1][arr.length + 1];
        return lcs(dp,nums,arr);
    }

    private int lcs(int[][] dp, int[] nums, int[] arr) {

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (nums[i-1] == arr[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[nums.length][arr.length];
    }
}