class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1 || arr.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);
        visited[0] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();

                if (idx == arr.length - 1) {
                    return moves;
                }

                if (idx < arr.length - 1 && !visited[idx + 1]) {
                    queue.add(idx + 1);
                    visited[idx + 1] = true;
                }

                if (idx > 0 && !visited[idx - 1]) {
                    queue.add(idx - 1);
                    visited[idx - 1] = true;
                }

                int num = arr[idx];
                if (map.containsKey(num)) {
                    for (int j : map.get(num)) {
                        if (!visited[j]) {
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                    map.remove(num);
                }
            }
            moves++;
        }

        return -1;
    }

}