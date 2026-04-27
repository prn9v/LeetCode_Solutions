import java.util.*;

class Solution {

    int[][] dirs = { { 1, 0 }, { 0, 1 } };

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        Map<String, Boolean> map = new HashMap<>();
        return dfs(grid, map, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, Map<String, Boolean> map, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }

        if (grid[i][j] == '(') {
            count++;
        } else {
            count--;
        }

        if (count < 0) {
            return false;
        }

        int remaining = (grid.length - i - 1) + (grid[0].length - j - 1);
        if (count > remaining)
            return false;

        if (count == 0 && i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }

        String key = i + "_" + j + "_" + count;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean res = false;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (dfs(grid, map, ni, nj, count)) {
                res = true;
                break;
            }
        }

        map.put(key, res);
        return res;
    }
}