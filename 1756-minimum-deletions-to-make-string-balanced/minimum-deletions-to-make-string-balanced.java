class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0;
        int bCount = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bCount += 1;
            } else {
                aCount -= 1;
            }

            if(min > aCount + bCount){
                min = aCount+bCount;
                minIdx = i;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i < minIdx) {
                if (ch == 'b') {
                    ans++;
                }
            }else if (i > minIdx) {
                if (ch == 'a') {
                    ans++;
                }
            }
        }

        return ans;
    }
}