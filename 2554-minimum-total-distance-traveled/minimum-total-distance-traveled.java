class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        HashMap<String, Long> map = new HashMap<>();

        return helper(map, robot, factory, 0, 0, 0);
    }

    private long helper(HashMap<String, Long> map, List<Integer> robot, int[][] factory, int i, int j, int k) {
        if (i == robot.size()) {
            return 0;
        }

        if (j == factory.length) {
            return Long.MAX_VALUE;
        }

        String key = i + "_" + j + "_" + k;
        if (map.containsKey(key)) return map.get(key);

        long skip = helper(map, robot, factory, i, j+1, 0);

        long curr = Long.MAX_VALUE;
        if (k < factory[j][1]) {
            long next = helper(map, robot, factory, i + 1, j, k + 1);

            if (next != Long.MAX_VALUE) { 
                long cost = Math.abs(robot.get(i) - factory[j][0]);
                curr = next + cost;
            }
        }

        long ans = Math.min(skip, curr);
        map.put(key, ans);

        return ans;
    }
}