/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list;
        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.add(child);
                }
                list.add(node.val);
            }
            ans.add(list);
        }

        return ans;
    }
}