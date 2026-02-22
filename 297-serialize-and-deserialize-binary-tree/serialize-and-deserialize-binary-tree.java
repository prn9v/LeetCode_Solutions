
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Queue<TreeNode> queue = new LinkedList<>();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(String.valueOf(node.val)).append("_");

                    if (node.left != null) {
                        queue.add(node.left);
                    } else {
                        queue.add(null);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    } else {
                        queue.add(null);
                    }
                } else {
                    sb.append(String.valueOf("N")).append("_");
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int i = 0;
        int n = data.length();
        while (i < n) {
            if (i < n && data.charAt(i) == '_') {
                i++;
            }

            if (i < n && data.charAt(i) == 'N') {
                queue.add(null);
                i++;
                continue;
            }

            int sign = 1;

            if (i < n && data.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            while (i < n && Character.isDigit(data.charAt(i))) {
                num = num * 10 + (data.charAt(i) - '0');
                i++;
            }

            queue.add(new TreeNode(sign * num));
        }

        TreeNode root = queue.poll();
        return helper(root, queue);
    }

    private TreeNode helper(TreeNode root, Queue<TreeNode> queue) {
        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                current.left = left;
                if (left != null) {
                    q.add(left);
                }
            }

            if (!queue.isEmpty()) {
                TreeNode right = queue.poll();
                current.right = right;
                if (right != null) {
                    q.add(right);
                }
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));