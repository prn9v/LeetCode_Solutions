class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> candidates = new ArrayList<>(map.keySet());

        Collections.sort(candidates, (w1, w2) -> {
            int freq1 = map.get(w1);
            int freq2 = map.get(w2);
            
            if (freq1 != freq2) {
                return freq2 - freq1;
            } else {
                return w1.compareTo(w2);
            }
        });

        return candidates.subList(0, k);
    }
}