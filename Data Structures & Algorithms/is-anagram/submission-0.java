class Solution {
    public boolean isAnagram(String s, String t) {
        // for each char c in String s, list of all chars
        // for each char in String t, remove char from list
        // if list.size() == 0, then they are anagrams

        // time complexity = O(length s * length t)
        // space complexity = O(length s)

/*
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }

        for (char c : t.toCharArray()) {
            if (charList.contains(c)) {
                charList.remove((Character) c);
            } else {
                return false;
            }
        }

        return charList.size() == 0;
*/

        // hashmap for s and hashmap for t where char c (key) and num times it shows up (val)
        // see if all values for each char are the same

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCharArray = new HashMap<>();
        for (char c: s.toCharArray()) {
            sCharArray.put(c, sCharArray.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (sCharArray.containsKey(c)) {
                sCharArray.put(c, sCharArray.get(c) - 1);
            } else {
                return false;
            }
            
            if (sCharArray.get(c) < 0) {
                return false;
            }
        }
        return true;


    }
}
