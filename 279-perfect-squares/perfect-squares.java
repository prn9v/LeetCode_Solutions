class Solution {
    public int numSquares(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(map, n, 0);
    }

    private int helper(HashMap<Integer, Integer> map, int n, int sum) {
        if (sum == n) {
            return 0;
        }

        if (map.containsKey(sum)) {
            return map.get(sum);
        }

        if (sum > n) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n - sum; i++) {
            sum += i * i;
            min = Math.min(min, 1 + helper(map, n, sum));
            sum -= i * i;
        }

        map.put(sum, min);
        return map.get(sum);
    }
}