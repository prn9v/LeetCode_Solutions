/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (TreeNode tree : trees) {
            map.put(tree.val, tree);

            if (tree.left != null) {
                children.add(tree.left.val);
            }

            if (tree.right != null) {
                children.add(tree.right.val);
            }
        }

        TreeNode root = null;
        for (TreeNode tree : trees) {
            if (!children.contains(tree.val)) {
                if (root != null) {
                    return null;
                }
                root = tree;
            }
        }

        if (root == null) {
            return null;
        }

        map.remove(root.val);

        if (!isValid(root, Long.MIN_VALUE, Long.MAX_VALUE, map)) {
            return null;
        }

        if (!map.isEmpty()) {
            return null;
        }

        return root;
    }

    private boolean isValid(TreeNode root, long min, long max, Map<Integer, TreeNode> map) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        if (root.left == null && root.right == null && map.containsKey(root.val)) {
            TreeNode node = map.remove(root.val);
            root.left = node.left;
            root.right = node.right;
        }

        return isValid(root.left, min, root.val, map) && isValid(root.right, root.val, max, map);
    }
}