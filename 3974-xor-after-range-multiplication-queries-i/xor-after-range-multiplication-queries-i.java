class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            for (int j = l; j <= r; j+=k) {
                long multiplied = (long) nums[j] * v;
                nums[j] = (int) (multiplied % MOD);
            }
        }

        int ans = 0;
        for (int n : nums) {
            ans = ans ^ n;
        }

        return ans;
    }
}