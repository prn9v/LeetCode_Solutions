class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int[] newCandidates = new int[target+1];
        for(int candidate : candidates) {
            if(candidate <= target) {
                newCandidates[candidate]++;
            }
        }

        backtrack(res, newCandidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> arr, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(arr));
            return;
        }

        if(target < 0){
            return;
        }

        for(int i = index; i <= target; i++) {
            if(candidates[i] == 0) {
                continue;
            }

            candidates[i]--;
            arr.add(i);
            backtrack(res, candidates, target-i, arr, i);
            arr.remove(arr.size()-1);
            candidates[i]++;
        }
    }
}