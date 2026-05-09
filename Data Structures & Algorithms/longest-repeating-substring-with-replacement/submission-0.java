class Solution {
    public int characterReplacement(String s, int k) {
        /*
        - start at index 0
        - keep increasing until different character found
        - keep track of how many current changes have been made
        - if number of changes <= k --> "make" change and keep going
        - if number of changes > k --> move the left pointer to the first character changed
            - keep track of max length
        */
        /*
        FIRST TRY: lowk messed up a bit cuz i was confused with othe rprobelm (longest substring no repeats)

        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;
        int numChanges = 0;
        List<Integer> indexes = new ArrayList<>();
        int maxLength = 0;
        Set<Character> curChars = new HashSet<>();
        char[] chars = s.toCharArray();

        while (right < chars.length) {
            if (curChars.contains(chars[right])) {
                if (numChanges < k) {
                    indexes.add(right);
                    right++;
                    numChanges++;
                    maxLength = Math.max(right - left + 1, maxLength);
                } else {
                    while (left < indexes.get(0)) {
                        curChars.remove(chars[left]);
                        left++;
                    }
                    indexes.remove(0);
                    right++;
                    maxLength = Math.max(right - left + 1, maxLength);
                }
            } else {
                curChars.add(chars[right]);
                maxLength = Math.max(right - left + 1, maxLength);
            }
        }
        return maxLength;
        */


        /*
        - keep hashmap of char to frequency to see which one's the most frequent in the window
        - replace lower frequent number --> if numReplacements < k, then this length is valid
        */

        Map<Character, Integer> count = new HashMap<>();
        int result = 0;

        int left = 0;
        int maxFrequency = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFrequency = Math.max(maxFrequency, count.get(s.charAt(r)));

            while ((r - left + 1) - maxFrequency > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, r-left+1);
        }
        return result;

        
    }
}
