class Solution {
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j< cols; j++){
                if (searchDFS(i, j, 0, board, word)){
                    return true;
                }
            }
        }

        return false;
    }

    // cur is the current index of word that is checking
    public boolean searchDFS(int i, int j, int cur, char[][] board, String word){
        // Return true when finish the entire word string
        if(cur == word.length()) return true;

        // out of bounds
        // not the matching character
        // character already visited
        if(i < 0 || j < 0 || i >= rows || j >= cols || word.charAt(cur) != board[i][j] || board[i][j] == '#'){
            return false;
        }

        // find the matching character
        board[i][j] = '#';

        // recursive DFS
        boolean res = searchDFS(i+1, j, cur+1, board, word) ||
         searchDFS(i, j+1, cur+1, board, word) ||
         searchDFS(i, j-1, cur+1, board, word) ||
         searchDFS(i-1, j, cur+1, board, word);

        board[i][j] = word.charAt(cur);

        return res;
    }
}
