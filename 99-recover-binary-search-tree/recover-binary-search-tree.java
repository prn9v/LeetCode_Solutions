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
    private TreeNode first = null;
    private TreeNode second = null;        
    private TreeNode previous = null;
    
    public void recoverTree(TreeNode root) {
    
        inOrderTraverse(root);

        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

        private void inOrderTraverse(TreeNode node) {
            if (node == null) {
                return;
            }
            //traverse left
            inOrderTraverse(node.left);

            if (previous != null && node.val < previous.val) {
                if (first == null) { // found the first misplaced node
                    first = previous;
                }
                second = node;
            }
            previous = node;
            inOrderTraverse(node.right);
        }
}
