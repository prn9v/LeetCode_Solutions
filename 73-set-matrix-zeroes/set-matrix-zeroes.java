class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int r: rowSet){
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[r][i] = 0;
            }
        }

        for(int c: colSet){
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }

    }
}