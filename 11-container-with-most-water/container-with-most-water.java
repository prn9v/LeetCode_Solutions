class Solution {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int curr = Math.min(height[i], height[j]) * (j-i);
            ans = Math.max(ans, curr);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}