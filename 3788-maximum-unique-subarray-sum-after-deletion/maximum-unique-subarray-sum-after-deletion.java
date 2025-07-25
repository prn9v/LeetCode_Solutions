class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }

        int sum = 0;
        for (int num : positiveNumsSet) {
            sum += num;
        }

        return sum;
    }
}