class Solution {
    public int longestBalanced(int[] nums) {
        HashSet<Integer> setEven = new HashSet<>();
        HashSet<Integer> setOdd = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            setEven.clear();
            setOdd.clear();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    setEven.add(nums[j]);
                } else {
                    setOdd.add(nums[j]);
                }
                if (setEven.size() == setOdd.size()) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }

        return ans;
    }
}