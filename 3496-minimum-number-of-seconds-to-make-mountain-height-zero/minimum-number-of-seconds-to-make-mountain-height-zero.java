class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long) getMin(workerTimes) * mountainHeight * (mountainHeight + 1) / 2;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
        long heightReduced = 0;

        for (int t : workerTimes) {

            long val = 1 + (8 * time) / t;
            long x = (long)((-1 + Math.sqrt(val)) / 2);

            heightReduced += x;

            if (heightReduced >= mountainHeight) {
                return true;
            }
        }

        return false;
    }

    private int getMin(int[] arr) {
        int min = arr[0];
        for (int a : arr) {
            min = Math.min(min, a);
        }
        return min;
    }
}