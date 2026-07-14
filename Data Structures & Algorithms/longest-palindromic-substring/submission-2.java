class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String cur = checkPalindrome(s, i);
            if (cur.length() > longest.length()) {
                longest = cur;
            }
        }
        return longest;
        
    }

    private String checkPalindrome(String s, int i) {
        String odd = checkOddPalindrome(s, i);
        String even = checkEvenPalindrome(s, i);
        if (odd.length() > even.length()) {
            return odd;
        }
        return even;
    }

    private String checkOddPalindrome(String s, int i) {
        int left = i-1;
        int right = i+1;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    private String checkEvenPalindrome(String s, int i) {
        int left = i;
        int right = i+1;
        if (right < s.length() && s.charAt(left) != s.charAt(right)) {
            return s.substring(i, i+1);
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);

    }
}
