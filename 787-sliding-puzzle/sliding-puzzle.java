

class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder str = new StringBuilder();
        for (int[] row : board) {
            for (int elem : row) {
                str.append((char)(elem + '0'));
            }
        }

        String target = "123450";
        String start = str.toString();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int[][] neighbors = {
                { 1, 3 },
                { 0, 2, 4 },
                { 1, 5 },
                { 0, 4 },
                { 1, 3, 5 },
                { 2, 4 }
        };

        queue.add(start);
        visited.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return moves;
                }

                int zero = curr.indexOf('0');
                for (int n : neighbors[zero]) {
                    String next = swap(curr, zero, n);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
}