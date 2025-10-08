class Solution {
    public int maxSubArray(int[] nums) {
        int max= nums[0];
        int currentSum= 0;
        
        for(int n: nums){
            // reset current sum
            if(currentSum < 0){
                currentSum = 0;
            }

            currentSum = currentSum + n;
            max=Math.max(max, currentSum);
        }
        
        return max;
    }
}