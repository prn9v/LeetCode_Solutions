class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int K = Math.min(m, n);

        // Prefix sums
        int[][] rowPref = new int[m][n + 1];     // rowPref[i][j+1] = sum of grid[i][0..j]
        int[][] colPref = new int[m + 1][n];     // colPref[i+1][j] = sum of grid[0..i][j]
        int[][] diagPref = new int[m + 1][n + 1]; // ↘ diagonal
        int[][] antiPref = new int[m + 1][n + 1]; // ↙ diagonal (extra column for safe indexing)

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPref[i][j + 1] = rowPref[i][j] + grid[i][j];
                colPref[i + 1][j] = colPref[i][j] + grid[i][j];
                diagPref[i + 1][j + 1] = diagPref[i][j] + grid[i][j];
                antiPref[i + 1][j] = antiPref[i][j + 1] + grid[i][j];
            }
        }

        // Try sizes from largest down; first valid found is answer
        for (int k = K; k >= 2; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {
                    int target = rowSum(rowPref, r, c, c + k - 1);

                    boolean ok = true;

                    // Check all rows
                    for (int i = r; i < r + k; i++) {
                        if (rowSum(rowPref, i, c, c + k - 1) != target) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;

                    // Check all columns
                    for (int j = c; j < c + k; j++) {
                        if (colSum(colPref, j, r, r + k - 1) != target) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;

                    // Check diagonals
                    if (diagSum(diagPref, r, c, k) != target) continue;
                    if (antiSum(antiPref, r, c, k) != target) continue;

                    return k;
                }
            }
        }

        return 1;
    }

    // sum of grid[r][c1..c2]
    private int rowSum(int[][] rowPref, int r, int c1, int c2) {
        return rowPref[r][c2 + 1] - rowPref[r][c1];
    }

    // sum of grid[r1..r2][c]
    private int colSum(int[][] colPref, int c, int r1, int r2) {
        return colPref[r2 + 1][c] - colPref[r1][c];
    }

    // ↘ diagonal sum from (r,c) of length k
    private int diagSum(int[][] diagPref, int r, int c, int k) {
        return diagPref[r + k][c + k] - diagPref[r][c];
    }

    // ↙ diagonal sum of kxk starting at top-left (r,c)
    // diagonal from (r, c+k-1) to (r+k-1, c)
    private int antiSum(int[][] antiPref, int r, int c, int k) {
        return antiPref[r + k][c] - antiPref[r][c + k];
    }
}
