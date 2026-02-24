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
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        return helper(root,sum);    
    }

    public int helper(TreeNode node,int sum){
        if (node == null) {
            return 0; // If the node is null, return 0 since it doesn't contribute to the sum.
        }
    
        // Update sum by adding the current node's contribution
        sum = (sum << 1) | node.val;
    
        // If it's a leaf node, return the sum
        if (node.left == null && node.right == null) {
            return sum;
        }
    
        // Recursively calculate the sum for the left and right subtrees and add them together
        return helper(node.left, sum) + helper(node.right, sum);
    }
}