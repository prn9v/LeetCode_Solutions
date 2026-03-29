class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return helper(dp, 0, 0, triangle);
    }

    private int helper(Integer[][] dp, int row, int col, List<List<Integer>> triangle) {
        if(row == triangle.size()) {
            return 0;
        }

        if (dp[row][col] != null) return dp[row][col];

        int down = helper(dp, row + 1, col, triangle);
        int diag = helper(dp, row + 1, col + 1, triangle);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(down, diag);
    }
}