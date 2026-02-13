class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        helper(str, ans, 0);
        return ans;
    }

    private void helper(StringBuilder sb, List<String> ans, int index) {
        if (index == sb.length()) {
            ans.add(sb.toString());
            return;
        }

        char original = sb.charAt(index);

        if (Character.isDigit(sb.charAt(index))) {
            helper(sb, ans, index+1);
        } else {
            sb.setCharAt(index, Character.toLowerCase(original));
            helper(sb, ans, index + 1);

            sb.setCharAt(index, Character.toUpperCase(original));
            helper(sb, ans, index + 1);

        }
    }
}