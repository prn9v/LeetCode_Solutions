class Solution {
    public int countNegatives(int[][] grid) {
        int rowCount = grid.length; // The number of rows in the grid.
        int colCount = grid[0].length; // The number of columns in the grid.
        int negativeCount = 0; // Initialize a count for negative numbers.
      
        for (int rowNum = rowCount - 1, colNum = 0; rowNum >= 0 && colNum < colCount;) {
            if (grid[rowNum][colNum] < 0) {
                negativeCount += colCount - colNum; 
                rowNum--; 
            } else {
                colNum++; 
            }
        }
        return negativeCount; 
    }
}