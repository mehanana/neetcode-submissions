class Solution {
    public int characterReplacement(String s, int k) {
        /*
        - want to keep the most common character and only replace the least common characters
        - use hashmap to see how many of each character in the current substring
        - we also keep track of the int mostCommon, if the (right-left+1) - mostCommon > k, then we need to save the current length (right-left) and then reduce the size of the substring
        - as we increase the right pointer, add count to curChar in the hashmap. then see if this new count > curMaxCount and replace if so. then see if the numebr of replacements is good. if not, decrease substring size
        */

        int left = 0;
        int right = 0;
        int maxChar = 0;
        int res = 0;
        Map<Character, Integer> counts = new HashMap();

        while (left <= right && right < s.length()) {
            counts.put(s.charAt(right), counts.getOrDefault(s.charAt(right), 0) + 1);
            maxChar = Math.max(maxChar, counts.get(s.charAt(right)));

            while ((right - left + 1) - maxChar > k) {
                counts.put(s.charAt(left), counts.get(s.charAt(left)) - 1);
                left++;
            }

            res = Math.max(right-left+1, res);
            right++;
        }
        return res;
        
    }
}
