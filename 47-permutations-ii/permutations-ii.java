class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(ans,nums,used,list);
        return ans;
    }

    private void helper(List<List<Integer>> ans,int[] nums,boolean[] used,List<Integer> list) {
        if(list.size() == nums.length) {
            if(!ans.contains(list)){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i] == true){
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            helper(ans,nums,used,list);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}