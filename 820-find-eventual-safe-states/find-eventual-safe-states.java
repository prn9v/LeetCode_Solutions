import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] outdegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            int from = i;
            int[] to = graph[i];

            for (int j : to) {
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(from);
                outdegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            if (map.containsKey(node)) {
                for (int prev : map.get(node)) {
                    outdegree[prev]--;

                    if (outdegree[prev] == 0) {
                        q.offer(prev);
                    }
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}