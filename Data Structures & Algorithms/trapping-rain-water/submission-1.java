class Solution {
    public int trap(int[] height) {
        /*
        - start with 2
        - next height is 0 (0 < 2), can maybe hold 2 units of water
            - next height is 3 (3>=2) --> this closes this "container"so this def holds 2 units of water
        - now the start is 3
        - next height is 1 ( 1 < 3), can maybe hold 3-1 = 2 units of water
            - next height is 0 (0 < 3), can maybe hold total of 2 + (3-0) = 5 units of water
            - next height is 1 (1 < 3), can maybe hold total of 5 + (3-1) = 7 units of water
            - next height is 3 (3 >= 3), so this closes this "container" so this def holds 7 units of water (total is now 2 + 7 = 9)
        - now the start is 3 (index 7)
            - next height is 2 ( 2 < 3), can maybe hold 1 unit of water
            - next height is 1 ( 1 < 3), can maybe hold 1+2= 3 units of water
            - end of int[] height, and since there's no closing, we don't add this to the total
        - return total = 9
        */

        /*
        at an index, take the max of all values to the left and right, then pick the min of these 2 values
        then subtract the current index's height to figure out amount we can trap at index height (if negative, return 0)
        repeat for all indexes and add amounts

        start with left at 0, right at height-1 --> keep moving the lower pointer left/right while keeping track of max left/right of the pointers are we go through
        */

/*
        int left = 0;
        int right = 1;
        int total = 0;

        while (left < right && right < height.length) {
            int curTotal = 0;
            if (height[right] < height[left]) {
                while (right < height.length) {
                    if (height[right] >= height[left]) {
                        total += curTotal;
                        left = right;
                        right++;
                        break;
                    } else {
                        curTotal += height[left] - height[right];
                    }
                    right++;
                }
            } else {
                left++;
                right++;
            }
        }
        return total;
        */

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
            }
            
        }
        return result;
    }
}
