class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[row.length - 1 - i];
                row[row.length - 1 - i] = temp;
            }
        }
    }
}