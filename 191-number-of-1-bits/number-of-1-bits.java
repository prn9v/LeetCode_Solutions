class Solution {
    public int hammingWeight(int n) {
        String b = Integer.toBinaryString(n);

        int ans = 0;
        for(int i = 0; i < b.length(); i++) {
            if(b.charAt(i) == '1') {
                ans++;
            }
        }

        return ans;
    }
}