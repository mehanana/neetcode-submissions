class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        - hashmap of int[] charCount to the list of words that match this
        - then build the result list after
        */

        Map<String, List<String>> charCount = new HashMap<>();
        for (String str : strs) {
            int[] curCount = new int[26];
            for (char c : str.toCharArray()) {
                curCount[c-'a']++;
            }
            String key = Arrays.toString(curCount);
            List<String> toAdd = charCount.getOrDefault(key, new ArrayList<>());
            toAdd.add(str);
            charCount.put(key,toAdd);
        }
        List<List<String>> res = new ArrayList<>(); 
        for (List<String> los : charCount.values()) {
            res.add(los);
        }
        return res;

    }
}
