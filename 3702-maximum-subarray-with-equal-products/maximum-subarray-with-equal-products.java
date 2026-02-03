
class Solution {
    public int maxLength(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (prod(nums, i, j)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private boolean prod(int[] nums, int start, int end) {

        long product = 1;
        long g = nums[start];
        long l = nums[start];

        for (int i = start; i <= end; i++) {

            product *= nums[i];

            g = gcd(g, nums[i]);

            l = lcm(l, nums[i]);

            if (product > l * g)
                return false;
        }

        return product == l * g;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

}