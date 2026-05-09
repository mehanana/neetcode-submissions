class Solution {
    public int findDuplicate(int[] nums) {
        /*
        originally thought of using a set, but that's not O(1) extra space
        linked list, but dk how that works with this
        */

        Set<Integer> result = new HashSet<>();
        for (int i : nums) {
            if (result.contains(i)) {
                return i;
            } else {
                result.add(i);
            }
        }

        return -1;
        
    }
}
