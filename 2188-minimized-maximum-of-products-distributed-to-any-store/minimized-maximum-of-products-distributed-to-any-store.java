class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = quantities[0];

        for(int q : quantities) {
            max = Math.max(max,q);
        }

        int low = 1;
        int high = max;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(quantities,n,mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] quantities, int n, int mid) {
        int storesNeeded = 0;
        for(int q : quantities) {
            storesNeeded += (q + mid - 1) / mid;
        }

        if(storesNeeded <= n) {
            return true;
        } else {
            return false;
        }
    }
}