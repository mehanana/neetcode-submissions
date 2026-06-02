class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (!isValidChar(leftChar) || !isValidChar(rightChar)) {
                if (!isValidChar(leftChar)) {
                    left++;
                }
                if (!isValidChar(rightChar)) {
                    right--;
                }
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
    
        }
        return true;
        
    }

    private boolean isValidChar(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
