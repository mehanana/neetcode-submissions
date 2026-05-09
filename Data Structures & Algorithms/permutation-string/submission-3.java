class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
        if any ordering of letters in s1 exists in s2, return true. false otherwise
        - traverse through s2 and if the current letter is present in s1, check to see if the next __ characters are also present in s1
        - the moment a letter is not present, check if the number of characters present = s1.length()

        - hashmap of letters in s1 and frequency
        - go through s2 and if current letter is present in s1, reduce count by 1 in the hashmap
        - keep going until letter is not present
            - check if right - left + 1 == s1.length() --> if true, return true
            - if false:
                - increase left until it equals right, and as we're increasing, add the letter/count to the hashmap
        */

/*
FIRST TRY: lowk not getting the right answer all the time
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s1.length(); i++) {
            count.put(s1.charAt(i), count.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while (right < s2.length()) {
            if (count.containsKey(s2.charAt(right))) {
                while (right < s2.length() && count.containsKey(s2.charAt(right))) {
                    if (count.get(s2.charAt(right)) == 0) {
                        break;
                    } else {
                        count.put(s2.charAt(right), count.get(s2.charAt(right)) - 1);
                        right++;
                    }
                }
                if (right - left == s1.length()) {
                    return true;
                } else {
                    while (left < right) {
                        count.put(s2.charAt(left), count.get(s2.charAt(left)) + 1);
                        left++;
                    }
                }
            }
            left++;
            right++;
        }
        return false;
        */

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) { // they used to be equal (which means it was added to matches) but now we incremented it too much (by 1), so we need to remove that match
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) { // they used to be equal, but not we decreased it, so that's why it's -1
                matches--;
            }
            l++;
        }
        return matches == 26;


        
        
    }
}
