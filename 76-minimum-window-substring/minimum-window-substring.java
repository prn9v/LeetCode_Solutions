class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int dwords = map.size();
        int i = 0, j = 0;

        int minSize = Integer.MAX_VALUE;
        int start = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0)
                    dwords--;
            }
            
            while (dwords == 0) {

                if (j - i + 1 < minSize) {
                    minSize = j - i + 1;
                    start = i;
                }

                char left = s.charAt(i);

                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);

                    if (map.get(left) == 1)
                        dwords++;
                }

                i++;
            }   
            j++;
        }

        return minSize == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minSize);
    }
}