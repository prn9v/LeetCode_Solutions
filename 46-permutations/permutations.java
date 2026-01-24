class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,used,new ArrayList<>(),ans);
        return ans;
    }

    private void helper(int[] nums,boolean[] used,List<Integer> list,List<List<Integer>> ans) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }

            used[i] = true;
            list.add(nums[i]);

            helper(nums,used,list,ans);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}