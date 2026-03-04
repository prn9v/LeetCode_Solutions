class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;

        int[][] seeds = new int[n][2];
        for(int i = 0; i < n; i++) {
            seeds[i][0] = plantTime[i];
            seeds[i][1] = growTime[i];
        }

        Arrays.sort(seeds,(a,b) -> b[1] - a[1]);

        int totalPlantTime = 0;
        int ans = 0;
        for(int[] seed: seeds){
            totalPlantTime += seed[0];
            ans = Math.max(ans,totalPlantTime+seed[1]);
        }

        return ans;
    }
}