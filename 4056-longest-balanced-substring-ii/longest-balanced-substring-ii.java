import java.util.HashMap;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n <= 2) {
            return n;
        }

        int ans = 1;

        // case-1 -> Single Character
        char prev = s.charAt(0);
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == prev) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 1;
                prev = s.charAt(i);
            }
        }

        // case-2 -> Pair of two
        HashMap<Integer, Integer> pairsDiff;
        char[][] pairs = { { 'a', 'b' }, { 'b', 'c' }, { 'a', 'c' } };

        for (char[] cs : pairs) {

            char ch1 = cs[0];
            char ch2 = cs[1];
            char other = (char) ('a' + 'b' + 'c' - ch1 - ch2);

            pairsDiff = new HashMap<>();
            pairsDiff.put(0, -1);

            int diff = 0;

            for (int i = 0; i < n; i++) {

                char ch = s.charAt(i);

                if (ch == other) {
                    pairsDiff = new HashMap<>();
                    pairsDiff.put(0, i);
                    diff = 0;
                } else {
                    if (ch == ch1)
                        diff++;
                    else
                        diff--;

                    if (pairsDiff.containsKey(diff)) {
                        ans = Math.max(ans, i - pairsDiff.get(diff));
                    } else {
                        pairsDiff.put(diff, i);
                    }
                }
            }
        }

        // case-3 -> For three characters
        HashMap<String, Integer> map = new HashMap<>();

        int countA = 0, countB = 0, countC = 0;
        map.put("0#0", -1);

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (ch == 'a')
                countA++;
            else if (ch == 'b')
                countB++;
            else
                countC++;

            int dAB = countA - countB;
            int dAC = countA - countC;

            String key = dAB + "#" + dAC;

            if (map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return ans;
    }
}