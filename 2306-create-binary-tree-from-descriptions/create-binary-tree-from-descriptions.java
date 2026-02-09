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
    public TreeNode createBinaryTree(int[][] descriptions) {
        if (descriptions.length == 0) {
            return  null;
        }

        HashMap<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            int isLeft = d[2];

            TreeNode parent = map.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = map.getOrDefault(childVal, new TreeNode(childVal));

            map.put(parentVal, parent);
            map.put(childVal, child);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }

        return null;
    }
}