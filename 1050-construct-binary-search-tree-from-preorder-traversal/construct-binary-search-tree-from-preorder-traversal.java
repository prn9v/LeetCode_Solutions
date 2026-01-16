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
    public TreeNode bstFromPreorder(int[] preorder) {
        List<Integer> list = new ArrayList<>();
        for (int x : preorder) list.add(x);
        return helper(list);
    }

    private TreeNode helper(List<Integer> list) {
        if (list.isEmpty()) return null;

        TreeNode root = new TreeNode(list.get(0));

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        // start from 1 so root is not included again
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < root.val) leftList.add(list.get(i));
            else rightList.add(list.get(i));
        }

        root.left = helper(leftList);
        root.right = helper(rightList);

        return root;
    }
}