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
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;

        while(preorder[0] != inorder[i]){
            i++;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+i),Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+i,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));

        return root;
    }
}