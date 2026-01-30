class Solution {
    public int countGoodSubstrings(String s) {

        int ans = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            String part = s.substring(i, i + 3);
            if(isUniqueLetters(part)){
                ans++;
            }
        }

        return ans;
    }

    private boolean isUniqueLetters(String str){
        if (str.charAt(0) != str.charAt(1) && str.charAt(1) != str.charAt(2)&& str.charAt(0) != str.charAt(2)) {
            return true;
        }

        return false;
    }
}