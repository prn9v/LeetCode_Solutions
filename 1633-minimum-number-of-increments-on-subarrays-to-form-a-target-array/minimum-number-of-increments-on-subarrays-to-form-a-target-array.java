class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];

        for(int i = 1; i < target.length; i++){
            int diff = target[i] - target[i-1];
            ans += Math.max(diff,0);
        }

        return ans;
    }
}