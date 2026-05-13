class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        int transaction = 2;
        boolean canBuy = true;
        int idx = 0;
        return helper(dp, idx, canBuy, transaction, prices);
    }

    private int helper(Map<String, Integer> dp, int idx, boolean canBuy, int transaction, int[] prices) {
        if (idx == prices.length) {
            return 0;
        }

        String key = idx + "_" + Boolean.toString(canBuy) + "_" + transaction;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (transaction == 0) {
            return 0;
        }

        if (canBuy) {
            int buy = -prices[idx] + helper(dp, idx + 1, false, transaction, prices);
            int skip = helper(dp, idx + 1, canBuy, transaction, prices);

            int b = Math.max(buy, skip);
            dp.put(key, b);
            return b;
        } else {
            int sell = prices[idx] + helper(dp, idx + 1, true, transaction - 1, prices);
            int hold = helper(dp, idx + 1, canBuy, transaction, prices);

            int b = Math.max(sell, hold);
            dp.put(key, b);
            return b;
        }
    }

}