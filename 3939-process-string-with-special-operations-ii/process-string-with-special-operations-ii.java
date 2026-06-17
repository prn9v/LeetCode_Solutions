class Solution {
    public char processStr(String s, long k) {
        long[] len = new long[s.length()];
        long curr = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)) {
                curr++;
            } else if(ch == '*'){
                if(curr > 0) {
                    curr--;
                }
            }else if (ch == '#') {
                curr *= 2;
            }
            len[i] = curr;
        }

        if(k >= curr) {
            return '.';
        }

        for(int i = s.length() - 1; i >= 0 ; i--) {
            char ch = s.charAt(i);
            long before = (i == 0)? 0 : len[i-1];

            if(Character.isLowerCase(ch)) {
                if(k == before) {
                    return ch;
                }
            } else if (ch == '#') {
                k %= before;
            } else if (ch == '%'){
                k = before - 1 - k;
            }
        }

        return '.';
    }
}