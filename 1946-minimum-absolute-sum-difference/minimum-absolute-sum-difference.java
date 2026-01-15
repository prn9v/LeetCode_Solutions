import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long sum = 0;       
        int bestGain = 0;   

        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];

            int originalDiff = Math.abs(a - b);
            sum += originalDiff;

            int idx = Arrays.binarySearch(sorted, b);

            if (idx < 0) idx = -idx - 1;  

            int bestNewDiff = originalDiff;

            if (idx < n) {
                bestNewDiff = Math.min(bestNewDiff, Math.abs(sorted[idx] - b));
            }

            if (idx - 1 >= 0) {
                bestNewDiff = Math.min(bestNewDiff, Math.abs(sorted[idx - 1] - b));
            }
            
            int gain = originalDiff - bestNewDiff;
            bestGain = Math.max(bestGain, gain);
        }

        long answer = (sum - bestGain) % MOD;
        return (int) answer;
    }
}
