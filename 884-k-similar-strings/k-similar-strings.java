import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s1);
        visited.add(s1);
        int swaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String str = queue.poll();
                
                if (str.equals(s2)) {
                    return swaps;
                }
                int i = 0;

                while (i < str.length() && str.charAt(i) == s2.charAt(i)) {
                    i++;
                }

                for (int j = i + 1; j < s1.length(); j++) {
                    if (str.charAt(j) == s2.charAt(i) && str.charAt(j) != s2.charAt(j)) {

                        String next = swap(str, i, j);

                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            swaps++;
        }
        return swaps;
    }

    private String swap(String s, int i, int n) {
        char[] str = s.toCharArray();
        char temp = str[i];
        str[i] = str[n];
        str[n] = temp;
        return new String(str);
    }
}