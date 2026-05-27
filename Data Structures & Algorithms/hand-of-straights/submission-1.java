class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        /*
        1. sort hand
        2. traverse through until you get to groupSize ( remove from list or smth )
        3. then start from beginning of list, and do the same thing
        - if at any point, you reach a value that's more than 1 away, return false
        - can also check if hand % groupSize == 0 first

        - build a frequency map of each value and traverse through that
        */

        if (hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : hand) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        
        for (int i : keys) {
            while (freq.getOrDefault(i, 0) > 0) {
                if (freq.getOrDefault(i, 0) > 0) {
                    freq.put(i, freq.get(i) - 1);
                    for (int j = i + 1; j < i + groupSize; j++) {
                        if (freq.getOrDefault(j, 0) > 0) {
                            freq.put(j, freq.get(j) - 1);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;


        
    }
}
