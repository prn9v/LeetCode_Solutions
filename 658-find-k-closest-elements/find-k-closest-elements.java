class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] == b[1]) {
                        return b[0] - a[0]; 
                    }
                    return b[1] - a[1]; 
                });

        for (int i = 0; i < k; i++) {
            pq.add(new int[] { arr[i], Math.abs(arr[i] - x) });
        }

        int idx = k;
        while (idx < arr.length) {
            pq.add(new int[] { arr[idx], Math.abs(arr[idx] - x) });

            if (pq.size() > k) {
                pq.poll();
            }
            idx++;
        }

        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[0]);
        }

        Collections.sort(ans);
        return ans;
    }
}