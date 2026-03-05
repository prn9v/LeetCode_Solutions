class Solution {
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i], '.'); // initialize empty board
        backtrack(result, board, 0, n);
        return result.size();
    }
    static void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        if(row == n) { // base case: all queens placed
            result.add(construct(board));
            return;
        }

        for(int col=0; col<n; col++) { // try all columns in this row
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';         // place queen
                backtrack(result, board, row+1, n); // go to next row
                board[row][col] = '.';         // remove queen (backtrack)
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int n) {
        // check column
        for(int i=0;i<row;i++) if(board[i][col]=='Q') return false;

        // check upper-left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) if(board[i][j]=='Q') return false;

        // check upper-right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++) if(board[i][j]=='Q') return false;

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++) res.add(new String(board[i]));
        return res;
    }
}