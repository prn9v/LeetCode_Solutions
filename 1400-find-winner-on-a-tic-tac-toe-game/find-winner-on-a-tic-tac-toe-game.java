class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        boolean playerA = true;

        for(int[] m : moves) {
            if(playerA){
                board[m[0]][m[1]] = 'X';
            } else {
                board[m[0]][m[1]] = 'O';
            }
            playerA = !playerA;
        }


        char ans = helper(board);

        if(ans == 'D') {
            if(moves.length == 9) {
                return "Draw";
            } else {
                return "Pending";
            }
        } else if (ans == 'A') {
            return "A";
        } else {
            return "B";
        }
    }

    private char helper(char[][] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {

                return board[i][0] == 'X' ? 'A' : 'B';
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '\0' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {

                return board[0][j] == 'X' ? 'A' : 'B';
            }
        }
        // Main diagonal
        if (board[0][0] != '\0' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {

            return board[0][0] == 'X' ? 'A' : 'B';
        }
        // Anti-diagonal
        if (board[0][2] != '\0' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {

            return board[0][2] == 'X' ? 'A' : 'B';
        }
        return 'D';
    }
}