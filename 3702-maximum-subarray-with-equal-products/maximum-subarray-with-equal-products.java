
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        
        for (int i = 0; i < n; i++) {
            long prod = 1;
            int gcdVal = nums[i];
            int lcmVal = nums[i];
            
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = lcm(lcmVal, nums[j]);
                
                if (prod == (long) gcdVal * lcmVal) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

}