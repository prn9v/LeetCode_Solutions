class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int ans = 0;
        Arrays.sort(costs);
        int i = 0;
        int n = costs.length;
        while(i < n && coins >= costs[i]){
            coins -= costs[i];
            ans++;
            i++;
        }
        return ans;
    }
}