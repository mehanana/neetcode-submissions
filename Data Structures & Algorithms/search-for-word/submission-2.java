class Solution {
    public boolean exist(char[][] board, String word) {
        /*
        - start at board[0][0] & if = word.charAt(0), do the rest of the steps
        - if not, move through the board to find the start
        - boolean[][] visited to see if we already went to that cell

        once we find start:
        - mark as visited
        - go to neighbor values, see if it equals word.charAt(1)
        - if yes, keep going through until we go through the whole word
            - if end of word reached, return true
        - if not, go back to start and keep going through the board

        - return false
        */

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < visited.length; row++) {
            for (int col = 0; col < visited[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (backtrack(board, visited, row, col, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < board.length && row >= 0 && col >= 0 && col < board[0].length && !visited[row][col]) {
            if (board[row][col] == word.charAt(index)) {
                // keep going through
                visited[row][col] = true;

                boolean found = backtrack(board, visited, row+1, col, word, index+1)
                || backtrack(board, visited, row-1, col, word, index+1)
                || backtrack(board, visited, row, col+1, word, index+1)
                || backtrack(board, visited, row, col-1, word, index+1);

                visited[row][col] = false;
                return found;

            }
        } 
        return false;
    }
}
