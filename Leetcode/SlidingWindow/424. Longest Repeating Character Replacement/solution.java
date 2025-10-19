class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res =0;
        int l=0;
        int maxValue = 0;

        for(int r = 0;r<s.length();r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r),0)+1); //count frequency

            // Update the most frequency character in map
            maxValue = Math.max(maxValue, count.get(s.charAt(r)));

            // check current window is valid
            while(((r-l+1) - maxValue) > k){
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1); // decrease frequency
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}