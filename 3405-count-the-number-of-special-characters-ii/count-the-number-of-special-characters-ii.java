class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] freqLower = new int[26];
        int[] freqUpper = new int[26];

        Arrays.fill(freqLower,-1);
        Arrays.fill(freqUpper,-1);

        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)) {
                freqLower[ch - 'a'] = i;
            }
        }

        for(int i = n-1; i >= 0; i--) {
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)) {
                freqUpper[ch - 'A'] = i;
            }
        }

        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(freqLower[i] != -1 && freqUpper[i] != -1 && freqLower[i] < freqUpper[i]) {
                ans++;
            }
        }

        return ans;
    }
}