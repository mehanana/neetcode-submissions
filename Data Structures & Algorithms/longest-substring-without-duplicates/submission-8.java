class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        - add the current letters in the substring to a set
        - increase the right pointer, if we reach a letter that's in the set, store teh cur length if it's the longest so far
        - then, increase left and remove from set until the cur letter is not in set
        */

        int res = 0;
        int left = 0;
        int right = 0;

        HashSet<Character> chars = new HashSet();

        while (left <= right && right < s.length()) {
            if (chars.contains(s.charAt(right))) {
                res = Math.max(res, right-left);
                while (chars.contains(s.charAt(right))) {
                    chars.remove(s.charAt(left));
                    left++;
                }
            } else {
                chars.add(s.charAt(right));
                right++;
            }
        }
        return Math.max(res, right - left);



    }
}
