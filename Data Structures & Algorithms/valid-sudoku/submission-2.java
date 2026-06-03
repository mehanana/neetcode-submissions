class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        HashMap<Integer (row, col, square), Set<Integer> (keep track of what values are in this row, col, square)
        
        - row = row / 3
        - col = col / 3
        - key = row + "," + col
        
        */

        HashMap<Integer, Set<Character>> rows = new HashMap();
        HashMap<Integer, Set<Character>> cols = new HashMap();
        HashMap<String, Set<Character>> squares = new HashMap();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // see if there's a number in the cell first
                if (board[row][col] == '.') {
                    continue;
                }
                
                String key = row/3 + "," + col/3;

                // check row
                if (rows.computeIfAbsent(row, k -> new HashSet()).contains(board[row][col])
                || cols.computeIfAbsent(col, k -> new HashSet()).contains(board[row][col])
                || squares.computeIfAbsent(key, k -> new HashSet()).contains(board[row][col])) {
                    return false;
                }
                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                squares.get(key).add(board[row][col]);
            }
        }
        return true;

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        char[] boxes = char[9];
        0-2 --> 0
        3-5 --> 1
        6-8 --> 2
        row = curRow / 3
        col = curRow / 3
        - add each value to set, if repeat, return false 
        - do this for each row, col, and box
        O(n^2) - time
        O(n^2) - space
        */
        /*

        
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

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
*/

        
    }
}
