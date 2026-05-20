
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] freq = new int[A.length+1];
        int[] ans = new int[A.length];
        int idx = 0;
        while (idx < A.length) {
            freq[A[idx]]++;
            freq[B[idx]]++;
            int count = 0;

            for (int i = 1; i < freq.length; i++) {
                if (freq[i] == 2) {
                    count++;
                }
            }
            ans[idx] = count;
            idx++;
        }       

        return ans;
    }
}