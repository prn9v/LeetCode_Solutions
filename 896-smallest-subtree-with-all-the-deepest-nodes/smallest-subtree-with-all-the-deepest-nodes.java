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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = depthOfTree(root);
        return dfs(root,0,maxDepth);
    }

    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depthOfTree(root.left),depthOfTree(root.right));
    }

    private TreeNode dfs(TreeNode node,int depth,int maxDepth) {
        if (node == null) {
            return null;
        }

        if (depth == maxDepth - 1 && node.left == null&& node.right == null) {
            return node;
        }

        TreeNode left = dfs(node.left, depth+1, maxDepth);
        TreeNode right = dfs(node.right, depth+1, maxDepth);

        if(left != null && right != null){
            return node;
        }

        return (left != null)? left : right;
    } 
}