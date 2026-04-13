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
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }
        
        HashMap<TreeNode,Integer> map = new HashMap<>();
        return helper(map,root);
    }

    private int helper(HashMap<TreeNode,Integer> map, TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int withOut = helper(map,root.left) + helper(map,root.right);

        int with = root.val;

        if (root.left != null) {
            with += helper(map,root.left.left) + helper(map,root.left.right);
        }

        if (root.right != null) {
            with += helper(map,root.right.left) + helper(map,root.right.right);
        }

        map.put(root, Math.max(with, withOut));
        return map.get(root);
    }
}