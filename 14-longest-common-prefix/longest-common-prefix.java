class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }

        int minLength = Math.min(strs[0].length(),strs[1].length());

        String common = "";
        for(int i = minLength; i >= 1; i--) {
            if(strs[0].substring(0,i).equals(strs[1].substring(0,i))) {
                common = strs[0].substring(0,i);
                break;
            }
        }

        if(strs.length == 2){
            return common;
        }

        for(int i = 2; i < strs.length; i++) {
            int j = 0;
            String str = strs[i];
            while(j < Math.min(common.length(),str.length()) && common.charAt(j) == str.charAt(j)){
                j++;
            }

            common = common.substring(0,j);
            if (common.isEmpty()) return ""; 
        }

        return common;
    }
}