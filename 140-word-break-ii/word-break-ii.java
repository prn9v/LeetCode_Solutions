class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(ans,s,wordDict,0,str);
        return ans;
    }

    private void helper(List<String> ans,String s,List<String> wordDict,int index,StringBuilder str) {
        if (index == s.length()) {
            str.setLength(str.length()-1);
            ans.add(str.toString());
            return;
        }

        int len = str.length();

        for (int i = index+1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (wordDict.contains(substring)) {
                str.append(substring).append(" ");
                helper(ans, s, wordDict, i, str);
                str.setLength(len);
            }
        }
    }
}