class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);

            if ((n & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int t = 0;
            int temp = n;
            while ((temp & 1) == 1) {
                t++;
                temp >>= 1;
            }

            int k = t - 1;
            ans[i] = n - (1 << k);
        }

        return ans;
    }

    private int flipFirstZeroFromRight(int x) {
        for (int i = 0; i < 32; i++) {
            if (((x >>> i) & 1) == 0) {
                return x | (1 << i);
            }
        }

        return x | 1;
    }
}