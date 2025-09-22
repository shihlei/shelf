class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Initial Value: amount + 1 (represents impossible/infinity)
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        // For each amount from 1 to target
        for (int i = 1; i <= amount; i++) {
            // Try each coin
            for (int c: coins) {
                if (i - c >= 0) {
                    // For any amount i, we try every coin c and take the minimum
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        // If dp[amount] is still amount + 1, it means impossible to make that amount
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}

/**
coins=[1,3,4,5] amout=7

DP -> bottom up

dp[0] = 0
dp[1] = 1
dp[2] = 2
dp[3] = 1
dp[4] = 1
dp[5] = 1
dp[6] = 2
dp[7] = 2 -> 1+dp[6]=3 or 1+dp[4]=2 or 1+dp[3]=2 or 1+dp[2]=3
 */