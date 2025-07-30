class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        helper(index,nums,list,ans);
        return ans;
    }

    private void helper(int index,int[] nums,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list)); 

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);                    
            helper(i + 1, nums, list, ans);     
            list.remove(list.size() - 1);        
        }
    }
}