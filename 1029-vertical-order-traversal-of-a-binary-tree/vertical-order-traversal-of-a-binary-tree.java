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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>();
        int row = 0;
        int col = 0;
        preorder(map, root, row, col);

        for (Map.Entry<Integer, PriorityQueue<int[]>> entry : map.entrySet()) {
            PriorityQueue<int[]> pq = entry.getValue();
            List<Integer> list = new ArrayList<>();

            while (!pq.isEmpty()) {
                int[] node = pq.poll();
                int value = node[1];
                list.add(value);
            }

            result.add(list);
        }

        return result;
    }

    private void preorder(
            TreeMap<Integer, PriorityQueue<int[]>> map,
            TreeNode root,
            int row,
            int col) {

        if (root == null)
            return;

        map.putIfAbsent(col,
                new PriorityQueue<>(
                        (a, b) -> {
                            if (a[0] != b[0])
                                return a[0] - b[0];
                            return a[1] - b[1];
                        }));

        map.get(col).add(new int[] { row, root.val });

        preorder(map, root.left, row + 1, col - 1);
        preorder(map, root.right, row + 1, col + 1);
    }
}