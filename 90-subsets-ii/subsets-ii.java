class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); 
        helper(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> list, int index, int[] nums) {

         ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) continue;
            
            list.add(nums[i]);
            helper(ans, list, i+1, nums);
            list.remove(list.size() - 1);
        }
    }
}