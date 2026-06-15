class Solution {
     private static final double EPS = 1e-6;

    private boolean backtrack(double[] arr, int n) {
        if (n == 1) {
            return Math.abs(arr[0] - 24.0) < EPS;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double a = arr[i];
                double b = arr[j];

                double[] next = new double[n - 1];

                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next[idx++] = arr[k];
                    }
                }

                double[] candidates = {
                    a + b,
                    a - b,
                    b - a,
                    a * b
                };

                for (double val : candidates) {
                    next[idx] = val;
                    if (backtrack(next, n - 1)) {
                        return true;
                    }
                }

                if (Math.abs(b) > EPS) {
                    next[idx] = a / b;
                    if (backtrack(next, n - 1)) {
                        return true;
                    }
                }

                if (Math.abs(a) > EPS) {
                    next[idx] = b / a;
                    if (backtrack(next, n - 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean judgePoint24(int[] nums) {
        double[] arr = new double[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = (double)nums[i];
        }

        return backtrack(arr,4);
    }
}