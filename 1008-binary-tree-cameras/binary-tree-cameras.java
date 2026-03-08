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

    class Node {
        TreeNode root;
        char ch;

        Node(TreeNode root, char ch) {
            this.root = root;
            this.ch = ch;
        }
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        
        Node stateTree = createStateTree(root);
        int cameras =  countCameras(stateTree);

        if(stateTree.ch == 'R'){
            cameras += 1;
        }

        return cameras;
    }

    private int countCameras(Node node) {
        if (node == null || node.root == null) {
            return 0;
        }

        int count = 0;

        if (node.ch == 'C') {
            count++;
        }

        count += countCameras(createStateTree(node.root.left));
        count += countCameras(createStateTree(node.root.right));

        return count;
    }

    private Node createStateTree(TreeNode root) {
        if (root == null) {
            return new Node(root, 'N');
        }

        Node leftState = createStateTree(root.left);
        Node rightState = createStateTree(root.right);

        Node node;

        if (leftState.ch == 'R' || rightState.ch == 'R') {
            node = new Node(root, 'C');
        } 
        else if (leftState.ch == 'C' || rightState.ch == 'C') {
            node = new Node(root, 'N');
        } 
        else {
            node = new Node(root, 'R');
        }

        return node;
    }
}