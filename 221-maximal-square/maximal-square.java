class Solution {
    public int maximalSquare(char[][] matrix) {
        Integer[][] dp = new Integer[matrix.length+1][matrix[0].length+1];
        int max = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, helper(matrix, i, j, dp));
            }
        }

        return max * max;
    }

    private int helper(char[][] matrix, int i, int j, Integer[][] dp) {
        if(i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if(matrix[i][j] == '0'){
            return 0;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int down = helper(matrix, i + 1, j, dp);
        int right = helper(matrix, i, j + 1, dp);
        int diagonal = helper(matrix, i + 1, j + 1, dp);

        return dp[i][j] = 1 + Math.min(down, Math.min(right, diagonal));
    }
}