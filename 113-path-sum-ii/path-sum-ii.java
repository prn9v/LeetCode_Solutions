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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> list = new ArrayList<>();
        list.add(root.val); 
        helper(ans,list,root,root.val,targetSum);
        return ans;
    }

    private void helper(List<List<Integer>> ans,List<Integer> list,TreeNode root,int sum,int targetSum) {
        if(root.left == null && root.right == null) {
            if(targetSum == sum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if(root.left != null){
            list.add(root.left.val);
            helper(ans,list,root.left,sum + root.left.val,targetSum);
            list.remove(list.size()-1);
        }

        if(root.right != null){
            list.add(root.right.val);
            helper(ans,list,root.right,sum + root.right.val,targetSum);
            list.remove(list.size()-1);
        }
    }
}