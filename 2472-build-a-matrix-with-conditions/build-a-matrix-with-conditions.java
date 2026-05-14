import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rowEdges = new HashMap<>();
        Map<Integer, List<Integer>> colEdges = new HashMap<>();
        int[] rowIndegree = new int[k + 1];
        int[] colIndegree = new int[k + 1];
        List<Integer> rowTopo = new ArrayList<>();
        List<Integer> colTopo = new ArrayList<>();

        for (int[] row : rowConditions) {
            int from = row[0];
            int to = row[1];

            rowIndegree[to]++;
            rowEdges.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }

        for (int[] col : colConditions) {
            int from = col[0];
            int to = col[1];

            colIndegree[to]++;
            colEdges.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (rowIndegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedRow = 0;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            rowTopo.add(q);
            processedRow++;
            if (rowEdges.containsKey(q)) {
                for (int x : rowEdges.get(q)) {
                    rowIndegree[x]--;
                    if (rowIndegree[x] == 0) {
                        queue.add(x);
                    }
                }
            }
        }

        if (processedRow != k) {
            return new int[0][0];
        }

        queue = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            if (colIndegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedCol = 0;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            colTopo.add(q);
            processedCol++;
            if (colEdges.containsKey(q)) {
                for (int x : colEdges.get(q)) {
                    colIndegree[x]--;
                    if (colIndegree[x] == 0) {
                        queue.add(x);
                    }
                }
            }
        }

        if (processedCol != k) {
            return new int[0][0];
        }

        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();
        int[][] ans = new int[k][k];

        for (int i = 0; i < rowTopo.size(); i++) {
            rowPos.put(rowTopo.get(i), i);
        }

        for (int i = 0; i < colTopo.size(); i++) {
            colPos.put(colTopo.get(i), i);
        }

        for (int num = 1; num <= k; num++) {

            int row = rowPos.get(num);
            int col = colPos.get(num);

            ans[row][col] = num;
        }

        return ans;
    }
}