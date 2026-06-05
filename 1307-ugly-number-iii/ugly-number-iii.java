class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(ab, c);

        long low = 1;
        long high = 2_000_000_000L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;

            if (count >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}