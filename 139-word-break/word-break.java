class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String w : wordDict) {
            set.add(w);
        }
        Boolean[] dp = new Boolean[s.length()];
        return helper(dp, 0,s,set);
    }

    private boolean helper(Boolean[] dp, int idx, String s, HashSet<String> set) {
        if(idx == s.length()){
            return true;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        for(int i = idx+1; i <= s.length(); i++){
            String sub = s.substring(idx,i);
            if(set.contains(sub)) {
                if(helper(dp, i,s,set)) {
                    return dp[idx] = true;
                }
            }
        }

        return dp[idx] = false;
    }
}