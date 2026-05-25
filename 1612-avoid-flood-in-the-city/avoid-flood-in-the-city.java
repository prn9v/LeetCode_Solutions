class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer,Integer> Lakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            if (rains[i] > 0){
                int lake = rains[i];
                ans[i] = -1;

                if(Lakes.containsKey(lake)) {
                    int prev = Lakes.get(lake);
                    Integer dryDay = dryDays.ceiling(prev);

                    if(dryDay == null){
                        return new int[0];
                    }

                    ans[dryDay] = lake;

                    dryDays.remove(dryDay);
                }

                Lakes.put(lake,i);
            } else {
                dryDays.add(i);
                ans[i] = 1;
            }
        }

        return ans;
    }
}