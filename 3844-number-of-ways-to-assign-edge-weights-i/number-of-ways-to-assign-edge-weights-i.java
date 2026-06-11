class Solution {
    private static final long MOD = 1_000_000_007L;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int depth = dfs(graph, 1, 0);

        long ans = modPow(2,depth-1);

        return (int) ans;
    }

    private int dfs(List<Integer>[] graph, int node, int parent) {
        int maxDepth = 0;

        for (int nei : graph[node]) {
            if (nei == parent) continue;

            maxDepth = Math.max(maxDepth,
                                1 + dfs(graph, nei, node));
        }

        return maxDepth;
    }

    private long modPow(long base, long exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }

}