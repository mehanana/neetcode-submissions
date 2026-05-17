class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        // pacific touches top row and left col
        // atlantic touches bottom row and right col
        for (int row = 0; row < heights.length; row++) {
            dfs(heights, pacific, row, 0, heights[row][0]);
            dfs(heights, atlantic, row, heights[0].length - 1, heights[row][heights[0].length - 1]);
        }
        for (int col = 0; col < heights[0].length; col++) {
            dfs(heights, pacific, 0, col, heights[0][col]);
            dfs(heights, atlantic, heights.length - 1, col, heights[heights.length - 1][col]);
        }

        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    res.add(Arrays.asList(row, col));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int row, int col, int prevHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) return;
        if (visited[row][col]) return;
        if (heights[row][col] < prevHeight) return;  // can't flow uphill

        visited[row][col] = true;
        dfs(heights, visited, row+1, col, heights[row][col]);
        dfs(heights, visited, row-1, col, heights[row][col]);
        dfs(heights, visited, row, col+1, heights[row][col]);
        dfs(heights, visited, row, col-1, heights[row][col]);
    }
}