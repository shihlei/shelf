class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // Base case: bottom row
        for(int j = 0; j <= word2.length(); j++){
            dp[word1.length()][j] = word2.length() - j;
        }

        // Base case: right most column
        for(int i = 0; i <= word1.length(); i++){
            dp[i][word2.length()] = word1.length() - i;
        }

        // Fill DP table from bottom-right to top-left
        for(int i = word1.length() - 1; i >= 0; i--){
            for(int j = word2.length() - 1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                }
            }
        }

        return dp[0][0];
    }
}
