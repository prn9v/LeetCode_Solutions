class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[10];
        helper(ans, list, visited, 0, k, n);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> list, boolean[] visited, int sum, int k, int n) {
        if (list.size() > k) {
            return;
        }

        if (list.size() == k && sum == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) {
                return;
            }

            visited[i] = true;
            sum += i;
            list.add(i);
            helper(ans, list, visited, sum, k, n);
            list.remove(list.size() - 1);
            sum -= i;
            visited[i] = false;
        }
    }
}