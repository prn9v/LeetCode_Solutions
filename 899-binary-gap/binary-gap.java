class Solution {
    public int binaryGap(int n) {
        if(n < 3){
            return 0;
        }

        int count = 0;
        int ans = 0;
        boolean startCount = false;

        while (n != 0) {
            if (n != 0 && (n & 1) == 1) {
                startCount = true;
            }

            n = n >> 1;

            while (n != 0 && startCount && (n & 1) == 0) {
                count++;
                n = n >> 1;
            }

            if (n != 0 && startCount && (n & 1) == 1) {
                ans = Math.max(ans, count + 1);
                startCount = false;
                count = 0;
            }
        }

        return ans;
    }
}