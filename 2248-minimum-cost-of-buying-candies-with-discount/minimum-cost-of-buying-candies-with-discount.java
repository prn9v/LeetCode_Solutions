class Solution {
    public int minimumCost(int[] cost) {
        int ans = 0;
        Arrays.sort(cost);
        
        int i = cost.length-1;
        int k = 1;
        while(i >= 0) {
            if(k != 3) {
                ans += cost[i];
                System.out.println(ans);
                k++;
            } else {
                k = 1;   
            }
            i--;
        }

        return ans;
    }
}