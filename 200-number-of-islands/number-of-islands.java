class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid,boolean[][] visited,int i,int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || 
    grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        for (int[] d : dir) {
            dfs(grid, visited, i + d[0], j+d[1]);
        }
    }


}