class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int ans = 0;

        for (int i = 0; i < points.length; i++) {

            int end = points[i][1];

            while (i + 1 < points.length &&
                   points[i + 1][0] <= end) {

                end = Math.min(end, points[i + 1][1]);
                i++;
            }

            ans++;
        }

        return ans;

    }
}