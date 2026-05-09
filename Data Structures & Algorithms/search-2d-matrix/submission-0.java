class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            /*
            1  2  3  4  5
            6  7  8  9  10
            11 12 13 14 15
            */

            int row = mid / matrix[0].length; // 6 / 4 = 1
            int col = mid % matrix[0].length; // 6 % 4 = 2 - 1 = 1

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
