class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Move objects based on 90 degree roatation
        for (int i = m-1; i >= 0; i--) {
            int pointerY = n-1;
            for (int j = n-1; j >= 0; j--) {
                if (boxGrid[i][j] == '.')
                    continue;

                if (boxGrid[i][j] == '*') {
                    pointerY = j - 1;
                    continue;
                }

                // If j and pointerY are same, that means no movement required
                if (j != pointerY) {
                    boxGrid[i][pointerY] = '#';
                    boxGrid[i][j] = '.';
                }
                pointerY--;
            }
        }

        char[][] result = new char[n][m];
        // Rotate 90
        for (int j = 0; j < n; j++) {
            for (int i = m-1; i >= 0; i--) {
                result[j][m-1-i] = boxGrid[i][j];
            }
        }

        return result;
    }
}