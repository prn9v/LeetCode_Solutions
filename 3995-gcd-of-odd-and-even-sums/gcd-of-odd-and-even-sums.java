class Solution {
    public int gcdOfOddEvenSums(int num) {
        // int n = num * 2;
        // int ts = (n * (n+1))/2;

        // int sumOdd = (ts - num)/2;
        // int sumEven = ts - sumOdd;

        // return gcd(sumOdd,sumEven);
        return num;
    }

    private int gcd(int x, int y) {
        while (x != 0 && y != 0) {
            if (x > y) {
                x %= y;
            } else {
                y %= x;
            }
        }
        return (x == 0) ? y : x;
    }
}