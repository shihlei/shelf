class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int result = 0;
        int currentSum = 0;

        // Represents an empty prefix before the array starts, so subarrays starting at index 0 can be counted.
        prefixSum.put(0, 1);

        // Compute prefix sums while iterating once, and count matches [currentSum − k]
        for(int n: nums){
            currentSum += n;
            int dif = currentSum - k;
            
            if(prefixSum.containsKey(dif)){
                result += prefixSum.get(dif);
            }

            // Add to hashmap to store the prefix
            prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0)+1);
        }

        return result;
    }
}
