class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // count the character in t into hashMap
        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;// string s
        int need = countT.size();// string t
        int[] res = {-1, -1};
        int resLength = Integer.MAX_VALUE;
        int l=0;

        for(int r = 0; r < s.length(); r++){
            // put into window
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // compare count from window = count in countT -> have +1
            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }

            // have == need -> removed the character not in t, to get the result
            while(have == need){
                // update result
                int curentLength = r-l+1;
                if(curentLength < resLength){
                    resLength = curentLength;
                    res[0] = l;
                    res[1] = r;
                }

                // pop from the left of window
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }

                // move left pointer
                l++;
            }
        }

        return resLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}

// time: O(n)
// space: 