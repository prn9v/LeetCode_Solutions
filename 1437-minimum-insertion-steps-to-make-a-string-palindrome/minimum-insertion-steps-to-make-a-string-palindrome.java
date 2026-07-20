class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int lps = lcs(s,rev,s.length());

        return s.length() - lps;
    }

    private int lcs(String s,String rev,int len){
        int[][] dp = new int[len+1][len+1];

        Arrays.fill(dp[0],0);

        for(int i = 0; i <= len; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[len][len];
    }
}