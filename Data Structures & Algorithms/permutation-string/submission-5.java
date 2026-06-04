class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        - make a frequency map for s1
        - fixed sliding window left & right distance = s1.length()
        - see if the frequency of letters in this matches frequency of s1, if yes return true
        - at the end return false
        */
        int[] s1Array = new int[26];
        for (char c : s1.toCharArray()) {
            s1Array[c - 'a']++;
        }

        int left = 0;
        int right = left+s1.length();
        while (right <= s2.length()) {
            // check if there's a match
            if (match(s2.substring(left, right), s1Array)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
        
    }

    private boolean match(String s, int[] freq) {
        int[] curFreq = new int[26];
        for (char c : s.toCharArray()) {
            curFreq[c - 'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != curFreq[i]) {
                return false;
            }
        }
        return true;

    }
}
