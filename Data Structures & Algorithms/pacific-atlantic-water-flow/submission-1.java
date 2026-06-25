class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*
        - for each cell in heights, see if it can reach pacific edge & atlantic edge
        */

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        // mark all left pacific cells & right atlantic cells
        for (int row = 0; row < heights.length; row++) {
            dfs(heights, row, 0, pacific, heights[row][0]);
            dfs(heights, row, atlantic[0].length-1, atlantic, heights[row][atlantic[0].length-1]);
        }

        // mark all top pacific cells & bottom atlantic cells
        for (int col = 0; col < heights[0].length; col++) {
            dfs(heights, 0, col, pacific, heights[0][col]);
            dfs(heights, atlantic.length-1, col, atlantic, heights[atlantic.length-1][col]);
        }

        List<List<Integer>> res = new ArrayList();

        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    res.add(new ArrayList(Arrays.asList(row, col)));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] ocean, int prevHeight) {
        if (row < 0 || col < 0 || row >= ocean.length || col >= ocean[0].length || ocean[row][col] || prevHeight > heights[row][col]) {
            return;
        }
        ocean[row][col] = true;
        dfs(heights, row + 1, col, ocean, heights[row][col]);
        dfs(heights, row - 1, col, ocean, heights[row][col]);
        dfs(heights, row, col + 1, ocean, heights[row][col]);
        dfs(heights, row, col - 1, ocean, heights[row][col]);
    }
}
