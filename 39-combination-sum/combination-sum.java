class Solution {
    List<List<Integer>> ans  = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        helper(list,candidates,target,0,0);
        return ans;
    }

    private void helper(List<Integer> list, int[] candidates, int target, int sum, int idx) {
        if(target == sum) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(sum > target){
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            if(candidates[i] > target - sum) {
                continue;
            }
            list.add(candidates[i]);
            helper(list,candidates,target,sum + candidates[i],i);
            list.remove(list.size()-1);
        }
    }
}