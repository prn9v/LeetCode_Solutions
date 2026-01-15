import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hCurr = hBars[0];
        int vCurr = vBars[0];

        int hLen = 1, hMax = 1;
        int vLen = 1, vMax = 1;

        for(int i = 1; i < hBars.length; i++){
            if (hBars[i] == hCurr + 1) {
                hLen++;
            } else {
                hLen = 1;
            }

            hCurr = hBars[i];

            if (hLen > hMax) {
                hMax = hLen;
            }
        }

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vCurr + 1) {
                vLen++;
            } else {
                vLen = 1;
            }

            vCurr = vBars[i];

            if (vLen > vMax) {
                vMax = vLen;
            }
        }

        int side = Math.min(hMax + 1, vMax + 1);

        return side*side;
    }
}