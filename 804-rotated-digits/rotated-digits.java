class Solution {
    public int rotatedDigits(int n) {
        int[] rotated = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            boolean isValid = true;
            boolean isDifferent = false;

            int num = i;
            while (num != 0) {
                int digit = num % 10;
                int r = rotated[digit];
                if (r == -1) {
                    isValid = false;
                } else if(r == 2 || r == 5 || r == 6 || r == 9) {
                    isDifferent = true;
                }
                num = num/10;
            }

            if (isValid && isDifferent) {
                ans++;
            }
        }

        return ans;
    }
}