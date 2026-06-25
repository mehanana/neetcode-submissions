class Solution {
    public void solve(char[][] board) {
        /*
        - any O on the edge cannot be surrounded
        - any O next to an O on the edge cannot be surround, etc.
        */

        // find all edge O's and mark them as smth else, like 'N', and dfs through its neighbors and if any others are also O, mark them as N as well
        for (int row = 0; row < board.length; row++) {
            dfs(row, 0, board);
            dfs(row, board[0].length-1, board);
            
        }
        for (int col = 0; col < board[0].length; col++) {
            dfs(0, col, board);
            dfs(board.length-1, col, board);
        }

        // go through each item in board & mark all O as X
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

        // mark all N as O
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'N') {
                    board[row][col] = 'O';
                }
            }
        }
        
    }

    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'N';
        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}
