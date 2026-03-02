class Solution {
    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length()+1];
        int low = 0;
        int high = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }

            ans[ans.length-1] = low;
        }

        return ans;
    }
}