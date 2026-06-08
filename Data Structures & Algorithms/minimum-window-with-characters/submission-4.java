class Solution {
    public String minWindow(String s, String t) {
        /*
        - have a count array for the characters in t
        - hashmap of char to number seen so far
        - if char count = t char count for this letter, increase have by 1
        - also have a int need that's the total number of unique characters we need
        - if have == need, then we can shrink the window
        - as we're shrinking, reduce the char count and if at any point we don't have enough of a character, we stop decreasing the window
        */

        if (t.isEmpty()) {
            return "";
        }

        int[] tCount = new int[128];
        for (char c : t.toCharArray()) {
            tCount[c]++;
        }
        int need = 0;
        for (int i : tCount) {
            if (i > 0) {
                need++;
            }
        }

        int have = 0;
        
        HashMap<Character, Integer> sCount = new HashMap();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;
        while (left <= right && right < s.length()) {
            sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0)+1);
            if (sCount.get(s.charAt(right)) == tCount[s.charAt(right)]) {
                have++;
            }
            
            while (have == need) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    leftIndex = left;
                    rightIndex = right;
                }
                sCount.put(s.charAt(left), sCount.get(s.charAt(left))-1);
                if (sCount.get(s.charAt(left)) == tCount[s.charAt(left)]-1) {
                    have--;
                }
                left++;
            }
            right++;
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(leftIndex, rightIndex+1);
        }
 
    }
}
