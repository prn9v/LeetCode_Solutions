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
    int ans = 0;

    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }

        helper(root);

        return ans;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        ans += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}