class Solution {
    public int trap(int[] height) {
        if(height.length == 0 || height == null){
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n]; 

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for (int j = n-2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        int trappedWater = 0;
        for (int k = 0; k < n; k++) {
            trappedWater += (Math.min(leftMax[k], rightMax[k])- height[k]);
        }

        return trappedWater;
    }
}