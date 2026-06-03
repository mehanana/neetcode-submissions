class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        - go through s and add char to set
        - if the char exists, move cur index ot the index+1 of repeated letter
        */
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> str = new HashSet();
        int res = 0;
        int left = 0;
        int right = 1;
        str.add(s.charAt(left));
        while (right < s.length()) {
            if (str.contains(s.charAt(right))) {
                res = Math.max(res, str.size());
                while (str.contains(s.charAt(right))) {
                    str.remove(s.charAt(left));
                    left++;
                }
            }
                str.add(s.charAt(right));
                right++;
            
        }
        
        return Math.max(res, str.size());
        
    }
}
