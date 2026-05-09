class Solution {
    public int maxArea(int[] heights) {
        /*
        - 2 pointer would be perf for this situation
        width = right-left
        Math.min(nums[left], nums[right]) * width
        get the max area if the width is maximized or the height is maximized
        - look at smaller value --> look at next value. if this value is greater than the smaller one, take it. if this value is greater than the bigger one, take it.
        - so actually just always move the smaller value because this is the height determining value
        */

        int left = 0;
        int right = heights.length - 1;
        int result = 0;

        while (left < right) {
            int curArea = (right - left) * Math.min(heights[left], heights[right]);
            if (curArea > result) {
                result = curArea;
            }
            if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
