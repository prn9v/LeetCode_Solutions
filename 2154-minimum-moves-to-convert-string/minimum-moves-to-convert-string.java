class Solution {
    public int minimumMoves(String s) {
        char[] arr = s.toCharArray();

        int i = 0;
        int ans = 0;
        while(i < s.length()) {
            char ch = arr[i];
            if(ch == 'O'){
                i++;
            } else {
                ans++;
                i += 3;
            }
        }

        return ans;
    }
}