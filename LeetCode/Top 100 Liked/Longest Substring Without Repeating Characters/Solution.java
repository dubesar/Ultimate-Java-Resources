import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the character and its latest idx while traversing the string from left to right
        Map<Character, Integer> map = new HashMap<>();
        int max=0;

        // i == start position of window
        // j = curr/end position of window being explored
        for(int i=0, j=0; j < s.length(); j++){
            char c = s.charAt(j);
            // If the current character has previously been seen and
            // the previous occurrence (idx) of the char >= the starting position of the window to be explored (i)
            if(map.containsKey(c) && map.get(c) >= i)
                i = map.get(c) + 1;
            int currWindow = j-i+1;
            max = Math.max(currWindow, max);
            map.put(c, j);
        }
        return max;
    }
}