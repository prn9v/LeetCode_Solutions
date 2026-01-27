class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,ans,list,0);
        return ans;
    }

    private void helper(int[] nums,List<List<Integer>> ans,List<Integer> list,int index) {
        if(index > nums.length){
            return;
        }

        ans.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,ans,list,i+1);
            list.remove(list.size()-1);
        }
    }
}