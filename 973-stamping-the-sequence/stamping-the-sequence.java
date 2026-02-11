class Solution {
    public int[] movesToStamp(String stamp, String target) {
        ArrayList<Integer> ans = new ArrayList<>();
        char[] S = stamp.toCharArray();
        char[] T=  target.toCharArray();

        int n = target.length();
        int m = stamp.length();

        boolean[] visited = new boolean[n];
        
        int moves = 0;

        while (moves < n) {
            boolean replaced = false;

            for (int i = 0; i <= n-m; i++) {
                if (!visited[i] && canReplace(T,i,S)) {
                    moves += replaceTarget(T,i,m);
                    visited[i] = true;
                    replaced = true;
                    ans.add(i);

                    if (moves == n) {
                        break;
                    }
                }
            }

            if (!replaced) {
                if (!replaced) return new int[0]; 
            }
        }

        Collections.reverse(ans);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private boolean canReplace(char[] T,int pos,char[] S) {
        for (int i = 0; i < S.length; i++) {
            if (T[i + pos] != '?' && T[i + pos] != S[i])
                return false;
        }
        return true;
    }

     private int replaceTarget(char[] T, int pos, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (T[i + pos] != '?') {
                T[i + pos] = '?';
                count++;
            }
        }
        return count;
    }
}