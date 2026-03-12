class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]);

        int[][] dp = new int[points.length][2];
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            dp[i][0] = points[i][1] - points[i][0];
            dp[i][1] = points[i][0];

            while (!pq.isEmpty() && dp[i][1] - pq.peek()[1] > k) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int val = pq.peek()[0] + points[i][0] + points[i][1];
                ans = Math.max(ans, val);
            }
            
            pq.offer(dp[i]);
        }

        return ans;
    }
}