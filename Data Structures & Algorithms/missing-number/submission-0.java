class Solution {
    public int missingNumber(int[] nums) {
        /*
        num[i] & i should be equal (since we want every number from 0 to nums length)
        */

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
        
    }
}
