#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>

// Helper function for DFS
void checkDFS(int** heights, int rows, int cols, int i, int j, int prev, bool** ocean) {
    // Boundary checks
    if (i < 0 || i >= rows || j < 0 || j >= cols) return;
    
    // Height check and visited check
    if (heights[i][j] < prev || ocean[i][j]) return;
    
    // Mark as visited
    ocean[i][j] = true;
    
    // Explore all four neighbors
    checkDFS(heights, rows, cols, i + 1, j, heights[i][j], ocean);
    checkDFS(heights, rows, cols, i, j + 1, heights[i][j], ocean);
    checkDFS(heights, rows, cols, i - 1, j, heights[i][j], ocean);
    checkDFS(heights, rows, cols, i, j - 1, heights[i][j], ocean);
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *returnColumnSizes array must be malloced, assume caller calls free().
 */
int** pacificAtlantic(int** heights, int heightsSize, int* heightsColSize,
     int* returnSize, int** returnColumnSizes) {

    int rows = heightsSize;
    int cols = heightsColSize[0];
    
    // Allocate 2D boolean arrays for pacific and atlantic
    bool** pacific = (bool**)malloc(rows * sizeof(bool*));// allocate "outer array"
    bool** atlantic = (bool**)malloc(rows * sizeof(bool*));
    for (int i = 0; i < rows; i++) {
        pacific[i] = (bool*)calloc(cols, sizeof(bool));  // calloc initializes to 0 (false)
        atlantic[i] = (bool*)calloc(cols, sizeof(bool));
    }
    
    // DFS from top and bottom rows
    for (int i = 0; i < cols; i++) {
        checkDFS(heights, rows, cols, 0, i, INT_MIN, pacific);           // first row
        checkDFS(heights, rows, cols, rows - 1, i, INT_MIN, atlantic);   // last row
    }
    
    // DFS from left and right columns
    for (int i = 0; i < rows; i++) {
        checkDFS(heights, rows, cols, i, 0, INT_MIN, pacific);           // first col
        checkDFS(heights, rows, cols, i, cols - 1, INT_MIN, atlantic);   // last col
    }
    
    // Count cells that can reach both oceans
    int count = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (pacific[i][j] && atlantic[i][j]) {
                count++;
            }
        }
    }
    
    // Allocate result array based on "count" (How many rows)
    int** result = (int**)malloc(count * sizeof(int*));
    // Allocates an array to store how many columns each result row has. (How many columns)
    *returnColumnSizes = (int*)malloc(count * sizeof(int));
    
    // Fill result array
    int idx = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (pacific[i][j] && atlantic[i][j]) {
                // Allocate space for one result [i, j] -> 2 integers (8 bytes)
                result[idx] = (int*)malloc(2 * sizeof(int));
                result[idx][0] = i; // result[0][0] = 0
                result[idx][1] = j; // result[0][1] = 4
                (*returnColumnSizes)[idx] = 2;  // Record column count -> Each result has 2 columns [2,2,2,2,2,2,2]
                idx++;
            }
        }
    }
    
    // Free temporary arrays (inner array)
    for (int i = 0; i < rows; i++) {
        free(pacific[i]);
        free(atlantic[i]);
    }
    free(pacific);
    free(atlantic);
    
    *returnSize = count; // 7
    return result;
}

// Test function
int main() {
    // Example: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
    int rows = 5, cols = 5;
    
    // Allocate heights array
    int** heights = (int**)malloc(rows * sizeof(int*));
    int data[5][5] = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    
    for (int i = 0; i < rows; i++) {
        heights[i] = (int*)malloc(cols * sizeof(int));
        for (int j = 0; j < cols; j++) {
            heights[i][j] = data[i][j];
        }
    }
    
    int* heightsColSize = (int*)malloc(rows * sizeof(int));
    for (int i = 0; i < rows; i++) {
        heightsColSize[i] = cols;
    }
    
    int returnSize;
    int* returnColumnSizes;
    int** result = pacificAtlantic(heights, rows, heightsColSize, &returnSize, &returnColumnSizes);
    
    // Print results
    printf("Cells that can reach both oceans:\n");
    for (int i = 0; i < returnSize; i++) {
        printf("[%d, %d]\n", result[i][0], result[i][1]);
        free(result[i]);
    }
    
    // Cleanup
    free(result);
    free(returnColumnSizes);
    for (int i = 0; i < rows; i++) {
        free(heights[i]);
    }
    free(heights);
    free(heightsColSize);
    
    return 0;
}

/*
Pointer to pointer:
1. I'm creating a 2D array of booleans
2. First I allocate an array of row pointers
3. Then I allocate each row

If we needed to optimize this further, I could refactor to use a single contiguous memory block,
which would improve cache performance. The trade-off is slightly more complex indexing.
For this problem size, the current approach is clear and sufficient
*/