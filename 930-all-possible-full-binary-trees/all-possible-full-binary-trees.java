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

    private static Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        return build(n);
    }

    private static List<TreeNode> build(int n) {
        if (memo.containsKey(n)) return memo.get(n);

        List<TreeNode> res = new ArrayList<>();

        // Base case
        if (n == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        // Try all odd splits
        for (int leftSize = 1; leftSize < n; leftSize += 2) {
            int rightSize = n - 1 - leftSize;

            List<TreeNode> leftTrees = build(leftSize);
            List<TreeNode> rightTrees = build(rightSize);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        memo.put(n, res);
        return res;
    }
}
