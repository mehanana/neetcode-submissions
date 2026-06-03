class Solution {
    public int maxArea(int[] heights) {
        /*
        - left and right
        - height = lower of the two
        - calculate area, see if it's the new max area
        - move the lower height's pointer
        - repeat until the pointers meet
        */
        int left = 0;
        int right = heights.length-1;
        int res = 0;
        while (left < right) {
            int curHeight = Math.min(heights[left], heights[right]);
            res = Math.max(res, curHeight * (right - left));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;


















        /*
        [1 7 2 5 4 7 3 6]
        left and right, start at both ends
        - height is always the lower value of heights[left] & heights[right]
        - calculate current area, which is (right - left) * (Math.min(heights[right], heights[left])); & compare to maxArea thus far
        - if height[left] is min height, we shift left
        - if height[right] is min height, we shift right
        - keep going until we can't move either pointer
        */
/*
        int res = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int min = Math.min(heights[left], heights[right]);
            int curArea = min * (right - left);
            res = Math.max(res, curArea);
            if (heights[left] == min) {
                left++;
            } else {
                right--;
            }
        }
        return res;
        */

        
    }
}
