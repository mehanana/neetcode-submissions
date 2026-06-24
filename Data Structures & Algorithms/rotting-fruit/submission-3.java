class Solution {
    public int orangesRotting(int[][] grid) {
        /*
        - find rotten fruit
        - turn neighbors into rotten & add to queue
        - repeat
        */
        Queue<int[]> rotten = new ArrayDeque<>();
        int count = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    rotten.add(new int[]{row, col});
                }
            }
        }

        while (!rotten.isEmpty()) {
            int size = rotten.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] coordinate = rotten.poll();
                int row = coordinate[0];
                int col = coordinate[1];
                
                if (row+1 < grid.length && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    rotten.add(new int[]{row+1, col});
                }
                if (row-1 >= 0 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    rotten.add(new int[]{row-1, col});
                }
                if (col+1 < grid[0].length && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    rotten.add(new int[]{row, col+1});
                }
                if (col-1 >= 0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    rotten.add(new int[]{row, col-1});
                }
            }
            
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(count, 0);
        
    }
}
