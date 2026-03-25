class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long total = 0;

        for(int row[] : grid) {
            for(int col: row) {
                total += col;
            }
        }

        if (total % 2 != 0) return false;

        long target = total/2;

        long prefix = 0;
        for (int i = 0; i < m - 1; i++) {
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            prefix += rowSum;
            if (prefix == target) return true;
        }

        long[] colSum = new long[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum[j] += grid[i][j];
            }
        }

        prefix = 0;
        for (int j = 0; j < n - 1; j++) {
            prefix += colSum[j];
            if (prefix == target) return true;
        }

        return false;
    }
}