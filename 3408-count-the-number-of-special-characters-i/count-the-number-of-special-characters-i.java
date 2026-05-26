class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freqUpper = new int[26];
        int[] freqLower = new int[26];
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(Character.isUpperCase(ch)){
                freqUpper[ch - 'A']++;
            } else {
                freqLower[ch - 'a']++;
            }
        }

        int ans = 0;
        for(int i = 0; i < freqUpper.length; i++) {
            if(freqUpper[i] >= 1 && freqLower[i] >= 1){
                ans++;
            }
        }

        return ans;
    }
}