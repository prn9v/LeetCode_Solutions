class Solution {
    public int divisorSubstrings(int num, int k) {
        String n = Integer.toString(num);
        int ans = 0;
        int i = 0;
        
        while (i + k <= n.length()) {
            String divisor = n.substring(i, i+k);
            int d = Integer.parseInt(divisor);
            if(d * 1 != 0 && num % d == 0) {
                ans++;
            }
            i++;
        }

        return ans;
    }
}