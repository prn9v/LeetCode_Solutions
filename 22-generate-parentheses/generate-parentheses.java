class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(list, 0, 0, str, n);
        return list;
    }

    private void helper(List<String> list, int left, int right, StringBuilder str, int n) {
        if (left == n && right == n) {
            list.add(str.toString());
            return;
        }

        if (left < n) {
            str.append('(');
            helper(list, left + 1, right, str, n);
            str.deleteCharAt(str.length() - 1);
        }

        if (right < left) {
            str.append(')');
            helper(list, left, right + 1, str, n);
            str.deleteCharAt(str.length() - 1);
        }
    }
}