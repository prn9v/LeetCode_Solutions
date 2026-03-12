import java.util.PriorityQueue;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        // max heap based on (yi - xi)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        int ans = Integer.MIN_VALUE;

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            // remove points outside window
            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }

            // compute equation
            if (!pq.isEmpty()) {
                ans = Math.max(ans, pq.peek()[0] + x + y);
            }

            // push current point
            pq.offer(new int[]{y - x, x});
        }

        return ans;
    }
}