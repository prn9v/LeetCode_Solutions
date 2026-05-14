
class Solution {
    public int maxProfit(int k, int[] prices) {
        Map<String, Integer> dp = new HashMap<>();
        return helper(dp, prices, 0, true, k);
    }

    private int helper(Map<String, Integer> dp, int[] prices, int idx, boolean canBuy, int rem) {
        if (idx == prices.length) {
            return 0;
        }

        if (rem == 0) {
            return 0;
        }

        String key = idx + "_" + Boolean.toString(canBuy) + "_" + rem;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (canBuy) {
            int buy = -prices[idx] + helper(dp, prices, idx + 1, !canBuy, rem);
            int skip = helper(dp, prices, idx + 1, canBuy, rem);

            int ans = Math.max(skip, buy);
            dp.put(key, ans);
            return ans;
        } else {
            int sell = prices[idx] + helper(dp, prices, idx + 1, !canBuy, rem - 1);
            int hold = helper(dp, prices, idx + 1, canBuy, rem);

            int ans = Math.max(sell, hold);
            dp.put(key, ans);
            return ans;
        }
    }
}