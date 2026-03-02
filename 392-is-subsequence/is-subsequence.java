class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        if(t.length() == 0){
            return false;
        }
        
        int idx = 0;

        for(int i = 0; i < t.length(); i++){
            if(idx == s.length()){
                return true;
            }
            if(t.charAt(i) == s.charAt(idx)) {
                idx++;
            }
        }

        if(idx == s.length()){
            return true;
        } else {
            return false;
        }
    }
}