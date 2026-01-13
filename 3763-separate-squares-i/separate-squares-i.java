class Solution {
    public double separateSquares(int[][] squares) {

        double totalArea = 0;
        double low = Double.POSITIVE_INFINITY;
        double high = Double.NEGATIVE_INFINITY;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l;
        }

        double target = totalArea / 2.0;
        double eps = 1e-6; 

        while (high - low > eps) { 
            double mid = (low + high) / 2.0;
            double belowArea = calculateBelowArea(mid, squares);

            if (belowArea < target) low = mid;
            else high = mid; 
        }

        return high;
    }

    private double calculateBelowArea(double y, int[][] squares) {
        double area = 0;

        for (int[] sq : squares) {
            double bottom = sq[1];
            double l = sq[2];
            double top = bottom + l;

            if (y <= bottom) continue;
            if (y >= top) area += l * l;
            else area += l * (y - bottom);
        }

        return area;
    }
}
