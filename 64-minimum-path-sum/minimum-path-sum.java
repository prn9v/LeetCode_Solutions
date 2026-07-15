class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return helper(0,0,grid,dp);
    }

    private int helper(int i, int j, int[][] grid, Integer[][] dp) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE / 2;
        }

        if(i == grid.length-1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        int right = grid[i][j] + helper(i,j+1,grid,dp);
        int down = grid[i][j] + helper(i+1,j,grid,dp);

        ans = Math.min(right,down);

        return dp[i][j] = ans;
    }
}