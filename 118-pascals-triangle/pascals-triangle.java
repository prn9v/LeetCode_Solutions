class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            dp[0][i] = 1;
            dp[i][0] = 1;
        }

        for(int i = 1; i < numRows; i++){
            for(int j  = 1; j < numRows; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<Integer>();
            int k = i;
            int m = 0;
            for(int j  = 0; j <= i; j++){
                list.add(dp[k][m]);
                k--;
                m++;
            }
            ans.add(list);
        }

        return ans;
    }
}