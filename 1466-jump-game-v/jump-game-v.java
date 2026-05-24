class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(dp, arr, d, i));
        }

        return ans+1;
    }

    private int helper(int[] dp, int[] arr, int d, int idx) {

        if (dp[idx] != 0) {
            return dp[idx];
        }

        int currAns = 0;

        for (int i = 1; i <= d; i++) {
            if (idx + i >= arr.length) {
                break;
            }

            if (arr[idx + i] >= arr[idx]) {
                break;
            }

            currAns = Math.max(currAns,1 + helper(dp, arr, d, idx + i));
        }

        for (int i = 1; i <= d; i++) {
            if (idx - i < 0) {
                break;
            }

            if (arr[idx - i] >= arr[idx]) {
                break;
            }

            currAns = Math.max(currAns, 1 + helper(dp, arr, d, idx - i));
        }
        dp[idx] = currAns;

        return currAns;
    }
}