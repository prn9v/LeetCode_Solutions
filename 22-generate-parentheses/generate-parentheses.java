class Solution {
    public List<String> generateParenthesis(int n) {
         ArrayList<String> ans = new ArrayList<>();
         StringBuilder str = new StringBuilder();
         helper(n,0,0,str,ans);
         return ans;
    }        

    private void helper(int n, int left, int right, StringBuilder str, ArrayList<String> ans){
        if(left + right == (2*n)){
            ans.add(str.toString());
            return;
        }

        if(left < n){
            helper(n,left+1,right,str.append("("),ans);
            str.deleteCharAt(str.length() - 1);
        } 

        if(right < left) {
            helper(n,left,right+1,str.append(")"),ans);
            str.deleteCharAt(str.length() - 1);
        }
    }
}