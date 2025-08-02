class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        TreeMap<Integer,Integer> map2 = new TreeMap<>();

        for (int val : basket1) {
            map1.put(val, map1.getOrDefault(val, 0) + 1);
        }
        for (int val : basket2) {
            map2.put(val, map2.getOrDefault(val, 0) + 1);
        }

        if(map1.equals(map2)){
            return 0;
        }

        Set<Integer> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        for(int key:allKeys){
            int total = map1.getOrDefault(key,0) + map2.getOrDefault(key,0);
           if ((total & 1) == 1){
                return -1;
            }
        }

        List<Integer> surplus = new ArrayList<>();
        for (int key : allKeys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            int diff = c1 - c2;

            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) surplus.add(key);
            }
        }

        for (int key : allKeys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            int diff = c2 - c1;

            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++) surplus.add(key);
            }
        }
        
        Collections.sort(surplus); 
        long cost = 0;
        int n = surplus.size();
        int minVal = Math.min(map1.firstKey(), map2.firstKey());

        for (int i = 0; i < n / 2; i++) {
            cost += Math.min(surplus.get(i), 2 * minVal);
        }

        return cost;
    }
}