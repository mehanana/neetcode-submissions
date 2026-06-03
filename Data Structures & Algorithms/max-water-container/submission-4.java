class Solution {
    public int maxArea(int[] heights) {
        /*
        [1 7 2 5 4 7 3 6]
        left and right, start at both ends
        - height is always the lower value of heights[left] & heights[right]
        - calculate current area, which is (right - left) * (Math.min(heights[right], heights[left])); & compare to maxArea thus far
        - if height[left] is min height, we shift left
        - if height[right] is min height, we shift right
        - keep going until we can't move either pointer
        */

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

        
    }
}
