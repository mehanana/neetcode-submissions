class Solution {
    public void setZeroes(int[][] matrix) {
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
    }

   
}
