class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, list, candidates, target, 0, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> list, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target - sum) {
                continue;
            }

            list.add(candidates[i]);
            helper(ans, list, candidates, target, sum + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}