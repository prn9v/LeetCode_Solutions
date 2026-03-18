class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                count += grid[i][j];
                grid[i][j] = count;
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += grid[i - 1][j];
            }
        }

        int i = 0;
        int j = grid[0].length - 1;
        int ans = 0;
        while (i < grid.length && j >= 0) {
            if (grid[i][j] > k) {
                j--;
            } else {
                ans += j + 1;
                i++;
            }
        }

        return ans;
    }
}