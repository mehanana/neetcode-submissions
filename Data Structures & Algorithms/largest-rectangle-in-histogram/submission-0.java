class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        Input: heights = [7,1,7,2,2,4]
        Output: 8 cuz 7,2,2,4 = w4 * h2 = 8

        - for each bar, find the left and right most barrier and then calculate the area. if this is greater than max area, replace
            - to find leftmost and rightmost, keep going until that bar height is less than the current index bar height
        - We can use a stack with a monotonically strictly increasing nature, but instead of storing values, we store indices 
        in the stack and perform operations based on the values at those indices. The top of the stack will represent the smaller 
        bar that we encounter while extending the current bar. To find the left and right boundaries, we perform this algorithm 
        from left to right and vice versa, storing the boundaries. Then, we iterate through the array to find the area for each 
        bar and return the maximum area we get.

        - As you scan left to right, maintain a stack of indices where heights are strictly increasing. When you hit a bar that 
        is shorter than the stack top, that shorter bar is the right boundary of the stack top's bar. And whatever is below the 
        stack top is the left boundary.

        */

         int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair: (index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
