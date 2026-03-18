class WordFilter {

    private HashMap<String,Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();

            for (int j = 0; j <= len; j++) {
                String p = word.substring(0, j);
                for (int k = 0; k <= len; k++) {
                    String s = word.substring(len-k);
                    map.put(p+"#"+s, i);
                }
            }
        }
    }
    
    public int f(String pref, String suff) {
        return map.getOrDefault(pref + "#" + suff, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */