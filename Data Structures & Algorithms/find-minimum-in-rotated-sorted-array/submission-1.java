class Solution {
    public int findMin(int[] nums) {
        /*
        - find the minimum
        - left & right
        - if mid > right, left increases
        - if mid < right, right decreases
        */
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else {
                right = mid;
            }

        }
        return nums[left];
        
    }
}
