class Solution {
    public int countNegatives(int[][] grid) {
        int negativeCount = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] < 0) {
                negativeCount += grid[i].length;
                continue;
            }

            if (grid[i][grid[i].length - 1] >= 0) {
                continue;
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    negativeCount++;
                } else {
                    continue;
                }
            }
        }

        return negativeCount;
    }
}