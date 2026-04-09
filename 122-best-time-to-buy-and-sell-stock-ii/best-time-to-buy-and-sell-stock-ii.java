class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        for(int i = 1; i < prices.length; i++) {
            int curr = prices[i] - prices[i-1];
            max = Math.max(max,max+curr);
        }

        return max;
    }
}