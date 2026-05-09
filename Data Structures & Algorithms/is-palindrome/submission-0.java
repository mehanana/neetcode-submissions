class Solution {
    public boolean isPalindrome(String s) {
        // valid --> first and last character match
        // Was... it a car or a cat I saw?
        // left pointer = 0
        // right pointer = length of s - 1


        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toLowerCase().toCharArray();

        while (left <= right) {
            if (!isAlphaNum(chars[left])) {
                left++;
            } else if (!isAlphaNum(chars[right])) {
                right--;
            } else if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isAlphaNum(char c) {
        return (c >= 48 && c <= 57)
        || (c >= 65 && c <= 90)
        || (c >= 97 && c <= 122);
    }
}
