import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        if (numCourses == 1) {
            ans[0] = 0;
            return ans;
        } 


        int[] inDegree = new int[numCourses]; 

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree[to]++;
        }

        int k = 0;
        int processed = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                ans[k] = i;
                k++;
            }
        }

        while (!queue.isEmpty()) {
            int edge = queue.poll();
            processed++;
            if (graph.containsKey(edge)) {
                for (int num : graph.get(edge)) {
                    inDegree[num]--;
                    if (inDegree[num] == 0) {
                        queue.add(num);
                        ans[k] = num;
                        k++;
                    }
                }
            }
        }

        if (processed == numCourses) {
            return ans;
        } else {
            return new int[]{};
        }
    }
}