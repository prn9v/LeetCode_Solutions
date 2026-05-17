import java.util.*;

class Solution {

    public int shortestPathAllKeys(String[] grid) {

        int rows = grid.length;
        int cols = grid[0].length();

        int startR = 0;
        int startC = 0;

        int allKeysMask = 0;

        // preprocessing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                char ch = grid[i].charAt(j);

                if (ch == '@') {
                    startR = i;
                    startC = j;
                }

                if (Character.isLowerCase(ch)) {
                    allKeysMask |= (1 << (ch - 'a'));
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // row, col, mask
        queue.add(new int[]{startR, startC, 0});

        boolean[][][] visited = new boolean[rows][cols][64];
        visited[startR][startC][0] = true;

        int moves = 0;

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];

                // current cell
                char ch = grid[r].charAt(c);

                // collect key
                if (Character.isLowerCase(ch)) {
                    mask |= (1 << (ch - 'a'));
                }

                // all keys collected
                if (mask == allKeysMask) {
                    return moves;
                }

                // explore neighbors
                for (int[] d : dirs) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    // bounds
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                        continue;
                    }

                    char next = grid[nr].charAt(nc);

                    // wall
                    if (next == '#') {
                        continue;
                    }

                    // lock check
                    if (Character.isUpperCase(next)) {

                        if ((mask & (1 << (next - 'A'))) == 0) {
                            continue;
                        }
                    }

                    if (!visited[nr][nc][mask]) {

                        visited[nr][nc][mask] = true;

                        queue.add(new int[]{
                            nr,
                            nc,
                            mask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}