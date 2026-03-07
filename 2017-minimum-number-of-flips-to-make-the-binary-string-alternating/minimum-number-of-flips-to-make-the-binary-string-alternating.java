class Solution {

    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        StringBuilder p1 = new StringBuilder(); // 010101...
        StringBuilder p2 = new StringBuilder(); // 101010...

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                p1.append('0');
                p2.append('1');
            } else {
                p1.append('1');
                p2.append('0');
            }
        }

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;

        int l = 0;

        for (int r = 0; r < 2 * n; r++) {

            if (str.charAt(r) != p1.charAt(r)) diff1++;
            if (str.charAt(r) != p2.charAt(r)) diff2++;

            if (r - l + 1 > n) {
                if (str.charAt(l) != p1.charAt(l)) diff1--;
                if (str.charAt(l) != p2.charAt(l)) diff2--;
                l++;
            }

            if (r - l + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}