class Solution {
    public int minDistance(String word1, String word2) {
        StringBuilder str = new StringBuilder(word1);
        HashMap<String,Integer> map = new HashMap<>();
        return helper(map, 0, str, word2);
    }

    private int helper(HashMap<String,Integer> map, int idx, StringBuilder str, String word2) {
        if (str.toString().equals(word2)) {
            return 0;
        }

        if (idx == str.length())
            return word2.length() - idx;
        if (idx == word2.length())
            return str.length() - idx;

        if (str.charAt(idx) == word2.charAt(idx)) {
            return helper(map, idx + 1, str, word2);
        }

        if (map.containsKey(str.toString() + "#" + word2.substring(0, idx + 1))) {
            return map.get(str.toString() + "#" + word2.substring(0, idx + 1));
        }

        char ch = str.charAt(idx);

        // option 1: replace a charcter
        int replace = 0;
        str.setCharAt(idx, word2.charAt(idx));
        replace = 1 + helper(map, idx+1, str, word2);
        str.setCharAt(idx, ch);

        // option 2: delete a character
        int delete = 0;
        str.deleteCharAt(idx);
        delete = 1 + helper(map, idx, str, word2);
        str.insert(idx, ch);

        // option 3: insert a character
        int insert = 0;
        str.insert(idx, word2.charAt(idx));
        insert = 1 + helper(map,idx+1, str, word2);
        str.deleteCharAt(idx);

        int val = Math.min(replace, Math.min(delete, insert));

        map.put(str.toString() + "#" + word2.substring(0, idx + 1), val);
        return map.get(str.toString() + "#" + word2.substring(0, idx + 1));
    }
}