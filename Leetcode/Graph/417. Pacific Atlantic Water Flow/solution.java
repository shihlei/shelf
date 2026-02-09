class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        //check visited or not
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i=0;i<cols;i++){
            checkDFS(heights, 0,i, Integer.MIN_VALUE, pacific);//first row
            checkDFS(heights, rows-1, i, Integer.MIN_VALUE, atlantic);//last row
        }

        // Find cells that can reach Atlantic Ocean
        for (int i = 0; i < rows; i++) {
            checkDFS(heights, i, 0, Integer.MIN_VALUE, pacific);//first col
            checkDFS(heights, i, cols - 1, Integer.MIN_VALUE, atlantic);//last col
        }

        //add to result list
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void checkDFS(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length) return;

        if (heights[i][j] < prev || ocean[i][j]) return;

        ocean[i][j] = true;//prevent dupilcate

        //run all four neighbors
        checkDFS(heights, i+1, j, heights[i][j], ocean);
        checkDFS(heights, i, j+1, heights[i][j], ocean);
        checkDFS(heights, i-1, j, heights[i][j], ocean);
        checkDFS(heights, i, j-1, heights[i][j], ocean);
    }
}

/**
Water can flow in four directions (up, down, left, or right) from a cell to
a neighboring cell with height equal or lower

Start from boundaries.
Find cells that can reach Pacific Ocean & Find cells that can reach Atlantic Ocean\
->  Find intersection (cells reachable from BOTH oceans)
time & space: O(m*n)
*/
