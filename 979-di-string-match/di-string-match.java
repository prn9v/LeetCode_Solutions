class Solution {
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length()+1];
        int low = 0;
        int high = s.length();
        int n=s.length();

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