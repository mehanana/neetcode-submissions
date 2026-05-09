class Solution {
    public int search(int[] nums, int target) {
        /*
        now this is what I was trying to do earlier
        - find pivot
        - do 2 binary searches (lowk can do 1 if i compare the last number & 1st number in 1st array to the target)


        [3,4,5,6,1,2]
        */

        int min = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            min = left + (right - left) / 2;
            
            if (nums[min] > nums[right]) {
                left = min + 1;
            } else {
                right = min;
            }
        }

        min = left;

        left = 0;
        right = nums.length - 1;

        if (nums[min] == target) {
            return min;
        } else if (target > nums[nums.length - 1]) {
            right = min - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        } else {
            left = min;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
        
    }
}
