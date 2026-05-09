class Solution {
    public int longestConsecutive(int[] nums) {
        // start of each sequence is checking if the number doesn't have a left neighbor
        // eg. if 2 was a start number, does the array have a '1'

        // convert array into a set, that way we'll have O(1) lookup
        // 1st, check if 2 has a left neighbor --> no, so it's the start of a sequence
            // then, check if 3 exists --> yes, so add to count
            // then check if 4 exists --> yes
            // then check if 5 exists --> yes
            // then check if 6 exists --> no
        // then go to next val, 20 --> left neighbor (19)? --> no
            // then check if 21 exists --> no
        // then go to next val, 4 --> left neighbor(3)? --> yes
        // then go to next val, 10, etc.
        // return longest sequence, which is the 2, 3, 4, 5, so return 4

        // time = O(n)
        // space = O(n) cuz need to make hashset

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int i : numSet) {
            if (!numSet.contains(i-1)) {
                // i is the start of a sequence
                int curLength = 1;
                while (numSet.contains(i+curLength)) {
                    curLength++;
                }
                if (curLength > longest) {
                    longest = curLength;
                }
            }
        }

        return longest;
        
    }
}
