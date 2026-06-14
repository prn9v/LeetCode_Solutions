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
    HashMap<Integer,Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root,0);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(max == entry.getValue()){
                ans.add(entry.getKey());
            }
        }

        return ans.stream()
          .mapToInt(Integer::intValue)
          .toArray();
    }

    private int helper(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        int leftSum = helper(root.left,sum);
        int rightSum = helper(root.right,sum);

        int value = leftSum + rightSum + root.val;
        int freq = map.getOrDefault(value, 0) + 1;
        map.put(value, freq);
        max = Math.max(max, freq);

        return value;  
    }
}