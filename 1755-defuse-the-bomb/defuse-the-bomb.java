class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];

        if (k == 0) {

            for (int i = 0; i < ans.length; i++) {
                ans[i] = 0;
            }

        } else if (k > 0) {
            int n = code.length;
            for (int i = 0; i < n; i++) {
                int count = k;
                int sum = 0;
                int idx = (i + 1) % n;
                while (count-- > 0) {
                    sum += code[idx];
                    idx = (idx + 1) % n;
                }
                ans[i] = sum;
            }
        } else {
            int n = code.length;
            for (int i = 0; i < n; i++) {
                int count = Math.abs(k);
                int sum = 0;
                int idx = (i - 1 + n) % n;

                while (count-- > 0) {
                    sum += code[idx];
                    idx = (idx - 1 + n) % n;
                }
                ans[i] = sum;
            }
        }

        return ans;
    }
}