class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String,Integer> map = new HashMap<>();
        return helper(prices,0,true,2,map);
    }


    private int helper(int[] prices, int idx, boolean canBuy, int trans, HashMap<String,Integer> map) {
        if(idx == prices.length) {
            return 0;
        }

        if(trans == 0) {
            return 0;
        }

        String key = idx + "_" + canBuy + "_" + trans;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(canBuy) {
            int buy = -prices[idx] + helper(prices,idx+1,false,trans,map);
            int skip = helper(prices,idx+1,true,trans,map);

            int max = Math.max(buy,skip);
            map.put(key,max);
            return max;
        } else {
            int sell = prices[idx] + helper(prices,idx+1,true,trans-1,map);
            int skip = helper(prices,idx+1,false,trans,map);
            int max = Math.max(sell,skip);
            map.put(key,max);
            return max;
        }
    }
}