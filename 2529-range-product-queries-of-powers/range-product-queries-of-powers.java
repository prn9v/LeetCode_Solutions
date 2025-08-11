class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1_000_000_007;
        int[] ans = new int[queries.length];
        List<Integer> powers = new ArrayList<>();

        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        int m = powers.size();
        long[] prefix = new long[m];
        prefix[0] = powers.get(0);
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * powers.get(i)) % mod;
        }

        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];

            if(left == 0){
                ans[i] = (int) prefix[right];
            } else {
                long numerator = prefix[right];
                long denominator = prefix[left-1];
                long inv = modPow(denominator, mod - 2, mod); 
                ans[i] = (int) ((numerator * inv) % mod);
            }
        }

        return ans;
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}