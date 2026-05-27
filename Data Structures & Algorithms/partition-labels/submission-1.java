class Solution {
    public List<Integer> partitionLabels(String s) {
        /*
        - go through s and map each character to the last index it shows up in
        - keep track of size, end (of partition so far), and output list
        - go through s and see what the last index is, store end as that and increase size
            - if the next charachter, and if the last index > end, replace end. else keep going through (while increasing size)
        */

        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        List<Integer> output = new ArrayList<>();
        int end = 0;
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            size += 1;
            end = Math.max(end, lastIndex.get(s.charAt(i)));
            if (i == end) {
                output.add(size);
                size = 0;
            }
        }
        return output;
        
    }
}
