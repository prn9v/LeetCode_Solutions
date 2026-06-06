class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Boolean> map = new HashMap<>();
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return helper(map, 0, 0, 0, s1, s2, s3);
    }

    private boolean helper(Map<String, Boolean> map, int i, int j, int k, String s1, String s2, String s3) {
        if (i >= s1.length() && j >= s2.length()) {
            return true;
        }

        if (i >= s1.length() && j < s2.length()) {
            return s3.substring(k).equals(s2.substring(j));
        }

        if (i < s1.length() && j >= s2.length()) {
            return s3.substring(k).equals(s1.substring(i));
        }

        if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) {
            return false;
        }

        String key = i + "_" + j + "_" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean ans = false;

        if (s1.charAt(i) == s3.charAt(k)) {
            ans |= helper(map, i + 1, j, k + 1, s1, s2, s3);
        }

        if (s2.charAt(j) == s3.charAt(k)) {
            ans |= helper(map, i, j + 1, k + 1, s1, s2, s3);
        }

        map.put(key, ans);
        return ans;
    }
}