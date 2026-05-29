class Solution {
    public void setZeroes(int[][] matrix) {
        /*
        Set<Integer> seenRow = new HashSet<>();
        Set<Integer> seenCol = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) { 
                    seenRow.add(row); 
                    seenCol.add(col); 
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (seenRow.contains(row) || seenCol.contains(col)) {
                    matrix[row][col] = 0;
                }

            }
        }
        */
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean rowZero = false; // is the first ROW zero??

        // go through every row + col
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // if we find a zero
                if (matrix[r][c] == 0) {
                    // set the first row [col] position to 0
                    matrix[0][c] = 0;
                    // set the first col [row] position to 0 (unless it's the first row, then set the boolean to true) 
                    if (r > 0) {
                        matrix[r][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        // go through each row + col again (not starting at the first) and if the first row/col pair is 0, then we set the whole row/col to 0
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // if the origin of the matrix is 0, then we can set that first col to 0
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }

        // if the first row is 0, then set the whole first row to 0
        if (rowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }
    }

   
}
