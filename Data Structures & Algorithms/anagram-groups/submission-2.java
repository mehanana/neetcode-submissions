class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        hashmap of string (sorted alphabetically) and list of all anagrams from strs
        for each str, check if the sorted one is in hashmap, if it is, add to that list, and if not add to the hashmap
        at end, combine all the lists in result and return that

        time complexity = O(num strs *  k log k (sort fnc) )
        space complexity = O(n · k)

        ----

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (anagrams.containsKey(sorted)) {
                anagrams.get(sorted).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                anagrams.put(sorted, newList);
            }
            ///////
            instead of if statement
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
            
        }

        return new ArrayList<>(anagrams.values());
        */


        /*
        BETTER SOLUTION : have a hash map that keeps track of count and list of strings
            - count = int[] where each index matches a letter (eg. 0 -> 'a', 1 -> 'b', 2 -> 'c', etc); for each letter in the current string, we'll increase the count at that index by 1 to show that the char exists in the string
            - list of strings that are anagrams --> if they have the same count array, that means they are anagrams
        */

        Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                // c - 'a' part means take the ASCII value of c and subtract it by the value of 'a' so 'a' = 0, 'b' = 1, etc.
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

}
