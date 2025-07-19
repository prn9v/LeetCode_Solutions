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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        ArrayList<TreeNode> sorted = new ArrayList<>(list);
        sorted.sort((a, b) -> Integer.compare(a.val, b.val));

        TreeNode first = null, second = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val != sorted.get(i).val) {
                if (first == null) {
                    first = list.get(i);
                } else {
                    second = list.get(i);
                    break;
                }
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
