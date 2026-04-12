class Solution {
    public int minimumDistance(String word) {
        HashMap<Character, int[]> map = new HashMap<>();
        HashMap<String,Integer> dp =  new HashMap<>();

        int i = 0;
        int j = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(ch, new int[] { i, j });
            j = (j + 1) % 6;
            if (j == 0) {
                i++;
            }
        }

        return helper(map, dp, word, 0, null, null);
    }

    private int helper(HashMap<Character, int[]> map, HashMap<String,Integer> dp, String word,
            int idx, int[] f1, int[] f2) {
        if (idx == word.length())
            return 0;

        if (dp.containsKey(idx + "_" + f1 + "_" + f2)) {
            return dp.get(idx + "_" + f1 + "_" + f2);
        }

        char ch = word.charAt(idx);
        int[] target = map.get(ch);

        // finger1
        int cost1 = 0;
        if (f1 != null) {
            cost1 = Math.abs(f1[0] - target[0]) + Math.abs(f1[1] - target[1]);
        }
        int res1 = cost1 + helper(map, dp, word, idx + 1, target, f2);

        // finger2
        int cost2 = 0;
        if (f2 != null) {
            cost2 = Math.abs(f2[0] - target[0]) + Math.abs(f2[1] - target[1]);
        }
        int res2 = cost2 + helper(map, dp, word, idx + 1, f1, target);

        int res = Math.min(res1, res2);
        dp.put(idx + "_" + f1 + "_" + f2, res);
        return dp.get(idx + "_" + f1 + "_" + f2);
    }
}