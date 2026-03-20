class Solution {
    public int uniquePathsIII(int[][] grid) {
        int i = 0, j = 0, empty = 0;

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == -1) {
                    empty++;
                }
                if (grid[x][y] == 1) {
                    i = x;
                    j = y;
                }
            }
        }

        int total = grid.length * grid[0].length;

        return helper(grid, i, j, total - empty);
    }

    private int helper(int[][] grid, int i, int j, int remaining) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return remaining == 1 ? 1 : 0;
        }

        int temp = grid[i][j];
        grid[i][j] = -1; // mark visited

        int paths = helper(grid, i + 1, j, remaining - 1)
                + helper(grid, i - 1, j, remaining - 1)
                + helper(grid, i, j + 1, remaining - 1)
                + helper(grid, i, j - 1, remaining - 1);

        grid[i][j] = temp;

        return paths;
    }
}