class Solution {
    public boolean isAnagram(String s, String t) {
        // if length diff -> return false
        if(s.length() != t.length()){
            return false;
        }

        // use a size 26 array to do + -
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i=0;i<count.length;i++){
            if(count[i] != 0){
               return false; 
            }
        }

        return true;
    }
}
