class Solution {
    public boolean hasDuplicate(int[] nums) {
        // set --> traverse through array and add to this set
        // if number already exists, return false
        // if we get through whole list, return true
        // time complexity -> O(n)
        // space complexity -> O(n)

        Set<Integer> allNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (allNums.contains(nums[i])) {
                return true;
            }
            else {
                allNums.add(nums[i]);
            }
        }
        return false;
    }
}