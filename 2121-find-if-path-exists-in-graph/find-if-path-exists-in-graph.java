class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        if(dest >= n) {
            return false;
        }

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, dest);
    }

    private boolean dfs(List<Integer>[] graph,boolean[] visited, int source, int dest){
        if(source == dest) {
            return true;
        }

        visited[source] = true;

        for (int next : graph[source]) {
            if (!visited[next]) {
                if (dfs(graph, visited, next, dest)) {
                    return true;
                }
            }
        }

        return false;
    }
}