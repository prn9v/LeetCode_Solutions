import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[][] store = new double[quality.length][3];

        for (int i = 0; i < quality.length; i++) {
            store[i][0] = quality[i];
            store[i][1] = wage[i];
            store[i][2] = (double)wage[i]/quality[i];
        }

        Arrays.sort(store, (a,b) -> Double.compare(a[2], b[2]));

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double cost = 0;
        double totalCost = Double.MAX_VALUE;

        for (int i = 0; i < store.length; i++) {
            double q = store[i][0];
            pq.add(q);
            cost += q;

            if (pq.size() > k) {
                cost -= pq.poll();
            }

            if (pq.size() == k) {
                totalCost = Math.min(totalCost, cost*store[i][2]);
            }
        }

        return totalCost;
    }
}