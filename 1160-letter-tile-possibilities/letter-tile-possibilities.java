import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> ans = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[] isVisited = new boolean[tiles.length()];
        helper(ans, sb, isVisited, tiles);
        return ans.size();
    }

    private void helper(HashSet<String> ans, StringBuilder sb, boolean[] isVisited, String tiles) {
        if (sb.length() != 0) {
            ans.add(sb.toString());
        }

        int length = sb.length();
        for (int i = 0; i < tiles.length(); i++) {
            if(isVisited[i]){
                continue;
            }

            isVisited[i] = true;
            sb.append(tiles.charAt(i));
            helper(ans, sb,isVisited, tiles);
            sb.setLength(length);
            isVisited[i] = false;
        }
    }
}