import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];

        // Step 1: Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Process each group
        for (List<Integer> list : map.values()) {
            int m = list.size();
            if (m == 1) continue;

            // Step 3: Build prefix sum
            long[] prefix = new long[m];
            prefix[0] = list.get(0);
            for (int i = 1; i < m; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            long total = prefix[m - 1];

            // Step 4: Compute result for each index
            for (int k = 0; k < m; k++) {
                int idx = list.get(k);

                // LEFT
                long leftSum = (k > 0) ? prefix[k - 1] : 0;
                long leftCount = k;
                long left = list.get(k) * leftCount - leftSum;

                // RIGHT
                long rightSum = total - prefix[k];
                long rightCount = m - k - 1;
                long right = rightSum - list.get(k) * rightCount;

                result[idx] = left + right;
            }
        }

        return result;
    }
}