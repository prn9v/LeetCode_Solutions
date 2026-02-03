class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, isUsed, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] isUsed, int i, int j, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }


        if (isUsed[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        isUsed[i][j] = true;

        boolean found = helper(board, word, isUsed, i + 1, j, idx + 1) ||
                helper(board, word, isUsed, i - 1, j, idx + 1) ||
                helper(board, word, isUsed, i, j + 1, idx + 1) ||
                helper(board, word, isUsed, i, j - 1, idx + 1);

        isUsed[i][j] = false;

        return found;
    }
}