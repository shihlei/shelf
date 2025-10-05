class Solution {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int island = 0;

        // iterate through each cell of the grid
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols ; c++){
                if(grid[r][c] == '1'){
                    island++;
                    dfs(grid, r, c);
                }
            }
        }

        return island;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        // mark as visited
        grid[r][c] = '0';

        // check 4 firsctions
        for(int[] d: directions){
            dfs(grid, r + d[0], c + d[1]);
        }
    }
}
