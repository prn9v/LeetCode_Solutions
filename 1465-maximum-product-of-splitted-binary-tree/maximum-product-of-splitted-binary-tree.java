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

    private long max = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long totalSum = treeSum(root);
        dfs(root, totalSum);
        return (int)(max % MOD);
    }

    private long treeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + treeSum(root.left) + treeSum(root.right);
    }

    private long dfs(TreeNode root, long totalSum) {
        if (root == null) {
            return 0;
        }

        long leftSum = dfs(root.left, totalSum);
        long rightSum = dfs(root.right, totalSum);

        long subTreeSum = leftSum + rightSum + root.val;

        long product = subTreeSum * (totalSum - subTreeSum);
        max = Math.max(max, product);

        return subTreeSum;
    }
}
