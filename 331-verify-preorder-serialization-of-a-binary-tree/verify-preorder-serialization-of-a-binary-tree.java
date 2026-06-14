class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int next = dfs(nodes, 0);
        return next == nodes.length;
    }

    private int dfs(String[] nodes, int i) {
        if (i >= nodes.length) {
            return -1;
        }

        if (nodes[i].equals("#")) {
            return i + 1;
        }

        int leftEnd = dfs(nodes, i + 1);
        if (leftEnd == -1) {
            return -1;
        }

        return dfs(nodes, leftEnd);
    }
}