class Solution {
    public void rotate(int[][] matrix) {
        /*
        [0 0] [0 1]
        [1 0] [1 1]

        [0 0] [0 1] [0 2]
        [1 0] [1 1] [1 2]
        [2 0] [2 1] [2 2]

        */
        int l = 0;
        int r = matrix.length - 1;

        while ( l < r ) {
            for(int i = 0; i < r - l; i++) {
                int top = l;
                int bottom = r;
                //save the topleft
                int topLeft = matrix[top][l + i];

                //move bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l];

                // move bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                // move top left into top right
                matrix[top + i][r] = topLeft;

            }
            r--;
            l++;
        }
        
    }
}
