class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] gains = new int[profits.length][2];

        for(int i = 0; i < gains.length; i++) {
            gains[i][0] = capital[i];
            gains[i][1] = profits[i];
        }

        Arrays.sort(gains,Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for(int j = 0; j < k; j++) {

            while(i < gains.length && gains[i][0] <= w) {
                pq.offer(gains[i][1]);
                i++;
            }

            if(pq.isEmpty()) break;

            w += pq.poll();
        }

        return w;
    }
}