import java.util.*;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();

        dp[0] = nums[0];
        dq.offer(0);

        int ans = dp[0];

        for (int i = 1; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            dp[i] = nums[i] + Math.max(0, dp[dq.peekFirst()]);

            ans = Math.max(ans, dp[i]);

            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return ans;
    }
}