class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        int n = sequence.length();
        int l = word.length();
         for (int i = 0; i < n; i++) {
            int count = 0;
            while (i + (count + 1) * l <= n &&
                sequence.substring(i + count * l, i + (count + 1) * l).equals(word)) {
                count++;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}