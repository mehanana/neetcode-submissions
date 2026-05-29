class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int left = 0, right = matrix[0].length - 1;
    int top = 0, bottom = matrix.length - 1;

    while (left <= right && top <= bottom) {
        // move right along top row
        for (int c = left; c <= right; c++) res.add(matrix[top][c]);
        top++;

        // move down along right col
        for (int r = top; r <= bottom; r++) res.add(matrix[r][right]);
        right--;

        // move left along bottom row
        if (top <= bottom) {
            for (int c = right; c >= left; c--) res.add(matrix[bottom][c]);
            bottom--;
        }

        // move up along left col
        if (left <= right) {
            for (int r = bottom; r >= top; r--) res.add(matrix[r][left]);
            left++;
        }
    }
    return res;
}
}
