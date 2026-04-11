class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return -1;
        }

        int min = Integer.MAX_VALUE;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 3) continue;

            Collections.sort(list);

            int size = list.size();

            for (int i = 0; i < size - 2; i++) {
                int first = list.get(i);
                int third = list.get(i + 2);

                int distance = 2 * (third - first);
                min = Math.min(min, distance);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}