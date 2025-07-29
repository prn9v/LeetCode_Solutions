class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,nums,list,ans);
        return ans;
    }

    private void helper(int index,int[] nums,List<Integer> list,List<List<Integer>> ans){
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                helper(index + 1, nums, list, ans);
                list.remove(list.size() - 1); 
            }
        }
    }

    private void swap(int i,int j,int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}