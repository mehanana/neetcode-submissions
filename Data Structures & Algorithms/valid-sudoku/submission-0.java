class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row can't have repeats --> each array
        // column can't have repeats
        // 3x3 grid cannot have repeats
        // any full square can only have a digit from 1-9

        // hashset for rows + columns to check for repeats
        // for the square, can use another hashset


        // by keeping a map of the int (row, col, (row,col)) and a set allows us to do this in 1 pass
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                // key for the square is gonna be the row, col of the 3x3 grid
                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }
}
