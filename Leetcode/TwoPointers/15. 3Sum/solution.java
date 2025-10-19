class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
            // skip the same value
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum > 0){
                    r--;
                } 
                else if (sum < 0) {
                    l++;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;

                    // move left pointer more when it is same with previous 
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }   
                }

            }
        }

        return res;
    }
}
/**
sorting -> two pointer

time: O(nlogn) sorting + O(n^2) -> O(n^2)
space: O(n) or O(1) depend on sorting
*/