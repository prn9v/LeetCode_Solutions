
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            map.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>()).add(prerequisites[i][0]);

            indegree[prerequisites[i][0]]++; 
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int processed = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            processed++;

            for(int neighbour : map.getOrDefault(curr, new ArrayList<>())) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return processed == numCourses;
    }
}