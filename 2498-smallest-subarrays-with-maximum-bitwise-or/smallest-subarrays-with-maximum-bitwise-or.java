class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int maxOr = 0;
        // Start from the end and keep track of current ORs
        int[] bitLastSeen = new int[32]; // Stores the last seen index for each bit

        for (int i = 0; i < 32; i++) {
            bitLastSeen[i] = -1; // Initialize to -1
        }

        for (int i = n - 1; i >= 0; i--) {
            // Update last seen positions for each bit
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    bitLastSeen[b] = i;
                }
            }

            // Find the farthest index we need to go to achieve max OR
            int farthest = i;
            for (int b = 0; b < 32; b++) {
                if (bitLastSeen[b] != -1) {
                    farthest = Math.max(farthest, bitLastSeen[b]);
                }
            }

            ans[i] = farthest - i + 1;
        }

        return ans;
    }
}
