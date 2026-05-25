class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(isPossible(position,m,mid)){
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean isPossible(int[] position, int m, int minDist) {
        int countBalls = 1;
        int lastPlaced = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= minDist) {
                countBalls++;
                lastPlaced = position[i];
            }

            if (countBalls == m) {
                return true;
            }
        }

        return false;
    }
}