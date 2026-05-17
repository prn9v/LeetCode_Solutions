class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1 || prices.length == 0) {
            return 0;
        }
        Map<String, Integer> dp = new HashMap<>();
        return helper(dp, prices, 0, true);
    }

    private int helper(Map<String, Integer> dp, int[] prices, int idx, boolean canBuy) {
        if (idx >= prices.length) {
            return 0;
        }

        String key = idx + "_" + canBuy;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (canBuy) {
            int buy = -prices[idx] + helper(dp, prices, idx + 1, false);
            int skip = helper(dp, prices, idx + 1, canBuy);
            int max = Math.max(skip, buy);
            dp.put(key, max);
            return max;
        } else {

            int sell = prices[idx] + helper(dp, prices, idx + 2, true);
            int hold = helper(dp, prices, idx + 1, canBuy);
            int max = Math.max(sell, hold);
            dp.put(key, max);
            return max;
        }
    }

}