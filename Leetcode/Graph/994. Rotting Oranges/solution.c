/**
 * Point structure to represent a cell coordinate in the grid
 * Replaces Java's int[] for queue elements
 */
typedef struct {
    int row;
    int col;
} Point;

/**
 * Find minimum time for all oranges to rot using multi-source BFS
 * 
 * @param grid: 2D array (0=empty, 1=fresh, 2=rotten)
 * @param gridSize: number of rows
 * @param gridColSize: array of column counts per row
 * @return: minimum minutes needed, or -1 if impossible
 */
int orangesRotting(int** grid, int gridSize, int* gridColSize) {
    // Input validation - prevent null pointer dereference
    if (grid == NULL || gridSize == 0 || gridColSize == NULL || gridColSize[0] == 0) {
        return -1;
    }

    int rows = gridSize;
    int cols = gridColSize[0];

    // Allocate queue for BFS (worst case: all cells are rotten oranges)
    // This allocates a CONTIGUOUS block of memory for 9 Point structures
    // In C, we manually manage the queue unlike Java's LinkedList
    Point* queue = (Point*)malloc(rows * cols * sizeof(Point));
    if(queue == NULL){
        return -1; // Handle allocation failure
    }

    // Direction vectors: up, left, down, right
    int directions[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int minutes = 0;
    int freshCount = 0;
    int front = 0; // Index of next element to dequeue (like poll() in Java)
    int rear = 0; // Index where next element will be enqueued (like offer() in Java)

    // Find all initially rotten oranges and count fresh ones
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            if (grid[r][c] == 2) {
                // Enqueue rotten orange (equivalent to queue.offer())
                queue[rear].row = r;
                queue[rear].col = c;
                rear++;
            }
            else if (grid[r][c] == 1) {
                freshCount++;
            }
        }
    }

    // No fresh oranges - all already rotten or empty
    if (freshCount == 0) {
        free(queue);  // Don't forget to free allocated memory in C!
        return 0;
    }

    // No rotten oranges but have fresh oranges
    // Check if queue is empty: front == rear
    if (front == rear) {
        free(queue);
        return -1;
    }

    // BFS - process level by level (each level = 1 minute)
    // Continue while queue has elements AND there are still fresh oranges
    while (front < rear && freshCount > 0) {
        // Get number of oranges rotting at current minute (equivalent to queue.size() in Java)
        int levelSize = rear - front;

        // Process all oranges that rot in this level
        for(int i =0; i < levelSize; i++){
            // Dequeue first element
            Point current = queue[front];
            front ++;

            int row = current.row;
            int col = current.col;

            // Check all 4 directions
            for (int d = 0; d < 4; d++) {
                int newRow = row + directions[d][0];
                int newCol = col + directions[d][1];

                // Check bounds and if it's a fresh orange
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] == 1) {
                    // Rot this orange
                    grid[newRow][newCol] = 2;

                    // Enqueue newly rotten orange (equivalent to queue.offer())
                    queue[rear].row = newRow;
                    queue[rear].col = newCol;
                    rear++;
                    
                    freshCount--;
                }
            }
        }
        // Increment time after processing current level
        minutes++;   
    }

    // Clean up allocated memory - required in C, not in Java (garbage collected)
    free(queue);

    // Return minutes if all fresh oranges rotted, else -1
    return freshCount == 0 ? minutes : -1;
}
