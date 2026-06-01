class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        - iteratre through nums
        - store each value in a set, since sets cannot contain duplicates
        - lookup with O(1) time as well, and before we add the number to the set, we check if it already exists
        - if it exists, return true. else add to set and continue
        - at end, return false
        */
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (numsSet.contains(num)) {
                return true;
            }
            numsSet.add(num);
        }
        return false;
        
    }
}