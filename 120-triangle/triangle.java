class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()+1][triangle.size()+1];
        return helper(0,0,triangle,dp);
    }

    private int helper(int row, int col, List<List<Integer>> list, Integer[][] dp) {
        if(row >= list.size() || col >= list.get(row).size()) {
            return 0;
        }

        if(row == list.size() - 1) {
            return list.get(row).get(col);
        }

        if(dp[row][col] != null) {
            return dp[row][col];
        }

        int ans = Integer.MAX_VALUE;

        int sum1 = list.get(row).get(col) + helper(row+1,col,list,dp);
        int sum2 = list.get(row).get(col) + helper(row+1,col+1,list,dp);

        ans = Math.min(sum1,sum2);

        return dp[row][col] = ans;
    }
}