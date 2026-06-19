class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }

                if (mat[nr][nc] != -1) {
                    continue;
                }

                mat[nr][nc] = mat[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        return mat;
    }
}