void dfs(char** grid, int rows, int cols, int i, int j){
    if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0'){
        return;
    }

    // mark visited
    grid[i][j] = '0';

    // check 4 firsctions
    dfs(grid, rows, cols, i, j + 1);
    dfs(grid, rows, cols, i + 1, j);
    dfs(grid, rows, cols, i, j - 1);
    dfs(grid, rows, cols, i - 1, j);
}

int numIslands(char** grid, int gridSize, int* gridColSize) {
    // Handle edge cases: null pointers or empty grid
    // In embedded systems, defensive programming prevents crashes!!
    if(grid == NULL || gridSize == 0 || gridColSize == NULL || gridColSize[0] == 0){
        return 0;
    }

    int rows = gridSize;
    int cols = gridColSize[0];
    int island = 0;

    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            if(grid[i][j] =='1'){
                island++;
                // Use DFS to mark all connected land cells as visited
                dfs(grid, rows, cols, i, j);
            }
        }
    }

    return island;
}

/*
NO malloc/free needed because:
- The grid is passed in by the caller (already allocated)
- We modify grid in-place using it as our "visited" tracker
- All variables (rows, cols, island, r, c) are stack-allocated primitives
- No dynamic memory allocation (no heap fragmentation)

*/