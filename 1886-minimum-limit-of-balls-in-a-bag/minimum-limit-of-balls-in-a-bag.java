class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = nums[0];
        for(int num : nums) {
            max = Math.max(max,num);
        }

        int low = 1;
        int high = max;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(nums,maxOperations,mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] nums, int maxOperations, int mid) {
        long operations = 0;

        for(int num : nums) {
            operations += (num-1)/mid;
        }

        if(operations <= maxOperations) {
            return true;
        } else {
            return false;
        }
    }
}