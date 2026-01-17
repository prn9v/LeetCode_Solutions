class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
            min[i] = minVal;
        }

        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] == min[j]) {
                j--;
                continue;
            }

            while (!stack.isEmpty() && stack.peek() <= min[j]) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() < nums[j]) {
                return true;
            } else {
                stack.push(nums[j]);
            }
            j--;
        }

        return false;
    }
}