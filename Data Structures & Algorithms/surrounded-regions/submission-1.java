class Solution {
    public void solve(char[][] board) {
        /*
        any O on the border cannot be captured
        any O not on border will be captured
        */

        // 1. DFS - capture unsurrounded regions (O -> T)
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O' &&
                (r == 0 || r == board.length-1 || c == 0 || c == board[0].length - 1)) {
                    capture (r, c, board);
                }
            }
        }

        // 2. capture surrounded regions (O -> X)
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'O' &&
                (r != 0 && r != board.length-1 && c != 0 && c != board[0].length - 1)) {
                    board[r][c] = 'X';
                }
            }
        }

        // 3. Uncapture unsurrounded regions (T -> O)
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }

        
    }

    public void capture(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        capture(row+1, col, board);
        capture(row-1, col, board);
        capture(row, col+1, board);
        capture(row, col-1, board);
    }
}
