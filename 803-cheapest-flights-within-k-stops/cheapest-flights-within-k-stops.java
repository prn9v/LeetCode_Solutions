
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new int[]{v, wt});
        }

        Integer[][] dp = new Integer[n][k + 2];

        return dfs(graph, src, dst, k + 1, dp);
    }

    private int dfs(ArrayList<ArrayList<int[]>> graph,
                    int curr, int target, int k,
                    Integer[][] dp) {

        if(curr == target) {
            return 0;
        }

        if(k == 0) {
            return -1;
        }

        if(dp[curr][k] != null) {
            return dp[curr][k];
        }

        int ans = Integer.MAX_VALUE;

        for(int[] edge : graph.get(curr)) {

            int next = edge[0];
            int wt = edge[1];

            int cost = dfs(graph, next, target, k - 1, dp);

            if(cost != -1) {
                ans = Math.min(ans, cost + wt);
            }
        }

        return dp[curr][k] = (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
