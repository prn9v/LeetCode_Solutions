class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length - 1) { // while end reaching the last index
            int farthest = farthest(nums, start, end); // curent start and end's farthest index
            start = end + 1; // then the start becomes the end + 1 because next element of end is the minimum range
            end = farthest; // end becomes the farthest
            jumps++;
        }

        return jumps;
    }

    private int farthest(int[] nums, int start, int end) {
        int farthest = 0;
        for (int i = start; i <= end; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }

        return farthest;
    }
}