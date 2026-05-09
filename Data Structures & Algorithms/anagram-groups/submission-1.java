class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        hashmap of string and list of its anagrams
        add everything to the result list after going through all strs
        return result
        use the anagram method from prev leetcode

        OR

        hashmap of string (sorted alphabetically) and list of all anagrams from strs
        for each str, check if the sorted one is in hashmap, if it is, add to that list, and if not add to the hashmap
        at end, combine all the lists in result and return that
        */

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
        }

        return new ArrayList<>(anagrams.values());
    }

}
