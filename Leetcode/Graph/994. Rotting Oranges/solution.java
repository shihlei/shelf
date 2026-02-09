class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        // Find all initially rotten oranges and count fresh ones
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r, c});
                }
                else if(grid[r][c] == 1){
                    freshCount++;
                }
            }
        }

        // no fresh oranges
        if(freshCount == 0){
            return 0;
        }

        // no rotten oranges but have fresh oranges
        if(queue.isEmpty()){
            return -1;
        }

        // BFS
        while(!queue.isEmpty() && freshCount > 0){
            int levelSize = queue.size();

            // Process all oranges that rot in this minute
            for(int i =0;i<levelSize;i++){
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Check all 4 directions
                for(int[] dir: directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check bounds and if it's a fresh orange
                    if(newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == 1){
                        // Rot this orange
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        freshCount--;
                    }
                }
            }

            minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}
