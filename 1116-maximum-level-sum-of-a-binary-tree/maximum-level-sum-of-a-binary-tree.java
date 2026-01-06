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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int maxLevel = 1;
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int sum = 0;
            level++;

            int levelLength = queue.size();

            for (int i = 0; i < levelLength; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);   
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (sum > max) {
                maxLevel = level;
                max = sum;
            }
        }

        return maxLevel;
    }
}