class Solution {
    public int[] diStringMatch(String s) {
        int n=s.length();
        int[] ans = new int[n+1];
        int low = 0;
        int high = s.length();
        

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }

            ans[n] = low;
        }

        return ans;
    }
}