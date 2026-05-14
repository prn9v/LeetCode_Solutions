class Solution {
    public boolean isGood(int[] nums) {
        int[] freq = new int[201];

        int n = 0;

        for (int num : nums) {
            freq[num]++;
            n = Math.max(n, num);
        }

        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) return false;
        }

        return freq[n] == 2;
    }
}