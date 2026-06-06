class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        - this could be indexes from 1-matrix size
        - find mid
        - find row --> mid / cols
        - find col --> mid % cols
        */

        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
