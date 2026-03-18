class Solution {
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        helper(list,str,0,visited,n);
        return list.get(k-1);
    }

    private void helper(List<String> list,StringBuilder str,int index,boolean[] visited,int n){
        if (index == n) {
            list.add(str.toString());
            return;
        }

        int len = str.length();
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            str.append(i);
            visited[i] = true;
            helper(list, str, index+1,visited, n);
            visited[i] = false;
            str.setLength(len);
        }
    }
}