class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        - start at index 0 & 1 --> add to curString
        - increase right by 1
            - if this char is in the curString; Math.max(maxLength, curString.length()) & increase left by 1
        */
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;
        int maxLength = 0;
        String curString = s.substring(left, left+1);

        while (right < s.length()) {
            if (curString.contains(s.substring(right, right+1))) {
                maxLength = Math.max(maxLength, curString.length());
                curString = curString.substring(1);
                left++;
            } else {
                curString += s.substring(right, right+1);
                right++;
            }
        }
        return Math.max(maxLength, curString.length());
    }
}
