class Solution {
    public int minOperations(String s) {
        int withZeroAsStart = 0;
        int withOneAsStart = 0;

        for(int i = 0; i < s.length(); i++) {
            if((i%2==0 && s.charAt(i) != '0') || (i%2!=0 && s.charAt(i) != '1') ){
                withZeroAsStart++;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if((i%2==0 && s.charAt(i) != '1') || (i%2!=0 && s.charAt(i) != '0') ){
                withOneAsStart++;
            }
        }

        return Math.min(withZeroAsStart,withOneAsStart);
    }
}