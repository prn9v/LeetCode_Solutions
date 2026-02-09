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
import java.util.*;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null) {
            return root;
        }
        ArrayList<Integer> inorder = new ArrayList<>();

        inorderTranversal(inorder,root);

        return constructBalanceTree(inorder,0,inorder.size()-1);
    }

    private TreeNode constructBalanceTree(ArrayList<Integer> inorder,int left,int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right)/2;
        TreeNode root = new TreeNode(inorder.get(mid));

        root.left = constructBalanceTree(inorder, left, mid-1);
        root.right = constructBalanceTree(inorder, mid+1, right);

        return root;
    }

    private void inorderTranversal(ArrayList<Integer> inorder,TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTranversal(inorder, root.left);
        inorder.add(root.val);
        inorderTranversal(inorder, root.right);
    }
}