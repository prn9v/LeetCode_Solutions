class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = createGraph(isConnected);

        boolean[] visited = new boolean[isConnected.length];
        int ans = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int i) {
        if (i < 0 || i >= visited.length || visited[i]) {
            return;
        }

        visited[i] = true;

        if (graph.containsKey(i)) {
            for (int j : graph.get(i)) {
                dfs(graph, visited, j);
            }
        }
    }

    private Map<Integer, List<Integer>> createGraph(int[][] matrix) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {

            if (matrix[i][j] == 1 && i != j) {
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
            }
        }
    }

        return graph;
    }
}