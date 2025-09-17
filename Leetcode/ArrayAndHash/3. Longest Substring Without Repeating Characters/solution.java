class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seem = new HashSet<>();
        int l=0;
        int max = 0;
        
        for(int r=0;r<s.length();r++){      
            // When duplicate found, move left pointer past previous occurrence   
            while(seem.contains(s.charAt(r))){
                seem.remove(s.charAt(l));
                l++;
            }
            seem.add(s.charAt(r));
            
            // Track maximum window size seen so far
            max = Math.max(max, r-l+1);
        }

        return max;
    }
}
