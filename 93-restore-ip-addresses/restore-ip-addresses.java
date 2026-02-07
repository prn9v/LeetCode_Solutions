import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(ans, s, 0, 0, new StringBuilder());
        return ans;
    }

    private void helper(List<String> ans, String s, int index, int segments, StringBuilder path) {
        if (segments == 4 && index == s.length()) {
            ans.add(path.toString());
            return;
        }

        if (segments == 4 || index == s.length()) {
            return;
        }

        int len = path.length();

        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            if (s.charAt(index) == '0' && i > index) break;

            int val = Integer.parseInt(s.substring(index, i + 1));
            if (val > 255) break;

            if (segments > 0) path.append('.');
            path.append(val);

            helper(ans, s, i + 1, segments + 1, path);

            path.setLength(len);
        }
    }
}