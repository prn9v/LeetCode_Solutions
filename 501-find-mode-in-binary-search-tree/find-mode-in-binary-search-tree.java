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
public class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> resultList = new ArrayList<>();
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if (val > maxFreq) {
                maxFreq = val;
                resultList.clear();
                resultList.add(key);
            } else if (val == maxFreq) {
                resultList.add(key);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    private void dfs(TreeNode root,HashMap<Integer, Integer> map){
        if (root == null) {
            return;
        }

        dfs(root.left, map);
        map.put(root.val,map.getOrDefault(root.val, 0)+1);
        dfs(root.right, map);
    }
}