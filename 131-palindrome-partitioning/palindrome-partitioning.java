import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(ans, list, s, 0);
        return ans;
    }

    private void helper(List<List<String>> ans, List<String> list, String s, int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String part = s.substring(i, j);
            if (isPalindrome(part)) {
                list.add(part);
                helper(ans, list, s, j);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        if (str.length() == 1) {
            return true;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}