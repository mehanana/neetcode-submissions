class Solution {
    public boolean isAnagram(String s, String t) {
        /*
        - go through s, store characters in hashmap and map the char to the number of times it appears
        - go through t
            - if char not in hashmap, return false
            - if char in hashmap & count == 0, return false
            - else, save count as count-1 and continue
        */
        /*
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1); 
        } 
        for (char c : t.toCharArray()) {
            if (!chars.containsKey(c)) {
                return false;
            }
            if (chars.get(c) == 0) {
                return false;
            }
            chars.put(c, chars.get(c)-1);
        }
        for (int i : chars.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
*/

        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            chars[c-'a']--;
        }
        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }
}
