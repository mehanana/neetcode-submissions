class Solution {
    public List<Integer> partitionLabels(String s) {
        /*
        s[0] --> see when it first appears & when it last appears
            - in this substring, go throuhg each char & see if its last appearance index is in the substring, if yes do nothing, if no, extend substring to this index
        - then repeat steps starting with end + 1
        */

        HashMap<Character, Integer> charToLast = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charToLast.put(c, i);
        }

        List<Integer> res = new ArrayList();

        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            int lastIndex = charToLast.get(c);

            for (int i = 0; i < lastIndex; i++) {
                char curChar = s.charAt(i);
                if (charToLast.get(curChar) > lastIndex) {
                    lastIndex = charToLast.get(curChar);
                }
            }

            res.add(lastIndex-index+1);
            index = lastIndex+1;
        }
        return res;



































        /*
        - go through s and map each character to the last index it shows up in
        - keep track of size, end (of partition so far), and output list
        - go through s and see what the last index is, store end as that and increase size
            - if the next charachter, and if the last index > end, replace end. else keep going through (while increasing size)
        */

/*
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
        */
        
    }
}
