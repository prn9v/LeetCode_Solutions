class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {

                    List<int[]> cells = new ArrayList<>();

                    boolean surrounded = dfs(board, i, j, visited, cells);

                    if (surrounded) {
                        for (int[] cell : cells) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean dfs(char[][] board,
                        int i,
                        int j,
                        boolean[][] visited,
                        List<int[]> cells) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (board[i][j] == 'X')
            return true;

        if (visited[i][j])
            return true;

        visited[i][j] = true;
        cells.add(new int[]{i, j});

        boolean surrounded = true;

        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)
            surrounded = false;

        surrounded &= dfs(board, i - 1, j, visited, cells);
        surrounded &= dfs(board, i + 1, j, visited, cells);
        surrounded &= dfs(board, i, j - 1, visited, cells);
        surrounded &= dfs(board, i, j + 1, visited, cells);

        return surrounded;
    }
}