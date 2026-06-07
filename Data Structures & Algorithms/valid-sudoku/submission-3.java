class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        - keep track of each row, col, and box (hashmap of key to set with the values in that row, col, box currently)
        - if a value is already there, return false. else, add it to the set
        - row & col, the key will be the row number or col number
        - box --> use String row % 3 & col % 3 as the key
        */

        Map<Integer, Set<Character>> rows = new HashMap();
        Map<Integer, Set<Character>> cols = new HashMap();
        Map<String, Set<Character>> boxes = new HashMap();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    char cur = board[row][col];
                    String key = row / 3 + "," + col / 3;
                    if (rows.get(row) == null) {
                        rows.put(row, new HashSet());
                    }
                    if (cols.get(col) == null) {
                        cols.put(col, new HashSet());
                    }
                    if (boxes.get(key) == null) {
                        boxes.put(key, new HashSet());
                    }

                    if (rows.get(row).contains(cur)
                        || cols.get(col).contains(cur)
                        || boxes.get(key).contains(cur)) {
                        return false;
                    }

                    rows.get(row).add(cur);
                    cols.get(col).add(cur);
                    boxes.get(key).add(cur);
                    
                }
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
