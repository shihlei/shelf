class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min_price = prices[0];

        for(int i = 1; i < prices.length; i++){
            max = Math.max(max, (prices[i] - min_price));

            // update the best time to buy
            if(prices[i] < min_price){
                min_price = prices[i];
            }
        }

        return max;
    }
}
