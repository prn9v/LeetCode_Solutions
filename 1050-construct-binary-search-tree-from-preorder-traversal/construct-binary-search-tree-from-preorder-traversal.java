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
    private int idx = 0;

    private TreeNode dfd(int[] preorder, int lowBound, int highBound) {
        if (idx == preorder.length || preorder[idx] <= lowBound || preorder[idx] >= highBound) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = dfd(preorder, lowBound, root.val);
        root.right = dfd(preorder, root.val, highBound);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfd(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}