class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }

    private int helper(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // BST pruning
        if (root.val > low) {
            sum += helper(root.left, low, high);
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val < high) {
            sum += helper(root.right, low, high);
        }

        return sum;
    }
}
