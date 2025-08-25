class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();
        for (int i = 0; i < m + n - 1; i++) {
            diagonals.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonals.get(i + j).add(mat[i][j]);
            }
        }

        for(int i = 2; i < diagonals.size(); i+=2){
            Collections.reverse(diagonals.get(i));
        }

        int[] result = new int[m * n];
        int idx = 0;
        for (ArrayList<Integer> diag : diagonals) {
            for (int val : diag) {
                result[idx++] = val;
            }
        }

        return result;
    }
}