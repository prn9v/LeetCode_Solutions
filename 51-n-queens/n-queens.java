class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> valid = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        backtrack(n, ans, visited, 0, valid);
        return ans;
    }

    private void backtrack(int n, List<List<String>> ans, boolean[][] visited, int row, List<String> valid) {
        if (row == n) {
            ans.add(new ArrayList<>(valid));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(visited, row, i)) {
                visited[row][i] = true;

                char[] rowArr = new char[n];
                Arrays.fill(rowArr, '.');
                rowArr[i] = 'Q';

                valid.add(new String(rowArr));

                backtrack(n, ans, visited, row + 1, valid);

                valid.remove(valid.size() - 1);
                visited[row][i] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] visited, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (visited[i][col] == true) {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j] == true) {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < visited.length; i--, j++) {
            if (visited[i][j] == true) {
                return false;
            }
        }

        return true;
    }
}