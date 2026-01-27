class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";

        if (s.length() <= 1) {
            return ans;
        }

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isNice(str)) {
                    if (maxLen < str.length()) {
                        maxLen = str.length();
                        ans = str;
                    }
                }
            }
        }

        if (maxLen == 0) {
            return "";
        } else {
            return ans;
        }
    }

    private boolean isNice(String str) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (lower[i] != upper[i]) { 
                return false;
            }
        }

        return true;
    }

}