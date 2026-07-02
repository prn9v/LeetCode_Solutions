class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];

        int startHealth = health - grid.get(0).get(0);
        if (startHealth < 1) {
            return false;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];
            int currHealth = cur[2];

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                int newHealth = currHealth - grid.get(nx).get(ny);

                if (newHealth > 0 && newHealth > best[nx][ny]) {
                    best[nx][ny] = newHealth;
                    queue.offer(new int[]{nx, ny, newHealth});
                }
            }
        }

        return false;
    }
}