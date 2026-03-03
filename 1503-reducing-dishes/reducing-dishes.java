class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int ans = 0;
        int val = 0;

        for(int i = satisfaction.length - 1; i >= 0; i--) {
            val = val + satisfaction[i];
            if(val < 0){
                break;
            }
            ans += val;
        }

        return ans;
    }
}