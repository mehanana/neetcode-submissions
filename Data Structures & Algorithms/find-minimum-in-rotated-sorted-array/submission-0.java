class Solution {
    public int findMin(int[] nums) {
        /*
        rotating n times moves each value n spaces to the right, looping around if needed
         - (curIndex + n) % nums.length
        
        - obviously binary search cuz O(log n)
        - but how do we know whether to increase or decrease

        3 4 5 6 1 2 --> target = 1
        regular binary search:
        - 5 > 1 --> move left
        - 4 > 1 --> move left
        - 3 > 1 --> last val, so return false

        rotating gives you 2 sorted arrays --> 3 4 5 6 / 1 2 --> " 3 4 5 6" and "1 2"
        - by finding that pivot point, we can run 2 binary searches
        - how to find pivot point
            - binary search until we reach that point, by comparing this value to the left and right one and seeing if it's increasing. if it decreases, then we know the last index of the 1st array


        - ok so im actually stupid and need to read the question better, the question was asking how to find the minimum :|
        */

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            } 
        }
        return nums[left];

    }
}
