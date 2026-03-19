class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            int[] colSum = new int[cols];

            for (int j = i; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    colSum[k] += matrix[j][k];
                }

                ans += subarraySum(colSum, target);
            }
        }

        return ans;
    }

    private int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}