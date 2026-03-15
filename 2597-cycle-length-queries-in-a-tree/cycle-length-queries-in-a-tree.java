class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            ans[i] = depth(a) + depth(b) - (2 * depth(lca(a,b))) + 1;
        }

        return ans;
    }

    private int depth(int a){
        int d = 1;
        while (a != 1) {
            a=a/2;
            d++;
        }
        return d;
    }

    private int lca(int a,int b){
        while (a != b) {
            if (a > b) {
                a = a/2;
            } else {
                b = b/2;
            }
        }
        return a;
    }
}