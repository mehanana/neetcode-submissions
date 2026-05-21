class Solution {
    public String longestPalindrome(String s) {
        /*
        - each character is a substring (base case)
        - extend by 2 characters and check if it's a palindrome
            - if yes, store it
            - extend it again
            - if no, go back to other string?
        */

        String res = "";
        int resLength = 0;

        // consider each index to be the center
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    res = s.substring(left, right+1);
                    resLength = right-left+1;
                }
                left--;
                right++;
            }

            // even length
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLength) {
                    res = s.substring(left, right+1);
                    resLength = right-left+1;
                }
                left--;
                right++;
            }
        }

        return res;
    }
}
