class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += computePalindrome(s, i);
        }
        return count;
    }

    private int computePalindrome(String s, int i) {
        return computeEvenPalindrome(s, i) + computeOddPalindrome(s, i);
    }

    private int computeEvenPalindrome(String s, int i) {
        int count = 0;
        int left = i;
        int right = i+1;
        if (right < s.length() && s.charAt(left) != s.charAt(right)) {
            return count;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    private int computeOddPalindrome(String s, int i) {
        int count = 1;
        int left = i-1;
        int right = i+1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
