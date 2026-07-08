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
class BSTIterator {

    TreeNode root;
    ArrayList<Integer> list;
    static int p;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.list = new ArrayList<>();
        inorder(root);
        this.p = -1;
    }
    
    public int next() {
        p+=1;
        if(p != list.size()){
            return list.get(p);
        }

        return 1;
    }
    
    public boolean hasNext() {
        if(p+1 != list.size()){
            return true;
        } else {
            return false;
        }
    }

    private void inorder(TreeNode root) {
        if(root == null){
            return;
        }

        inorder(root.left);
        this.list.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */