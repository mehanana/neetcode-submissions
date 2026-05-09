class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        /*
        int left, int right --> keep incrementing until s.charAt(0) == t.charAt(left)
        - then keep incrementing right until all letters of s have been seen
            - if all letters are present, then store this string (if this is shorter than the prev stored string)
            - if all letters aren't present, increment left by 1 and reset r to be at left
        */

        int minLength = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int have = 0;
        int need = count.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            if (count.containsKey(c) && windowCount.get(c).equals(count.get(c))) {
                have++;
            }

            while (have == need) {
                if ((right - left + 1) < resLen) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (count.containsKey(leftChar) && windowCount.get(leftChar) < count.get(leftChar)) {
                    have--;
                }
                left++;
            }
            right++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
