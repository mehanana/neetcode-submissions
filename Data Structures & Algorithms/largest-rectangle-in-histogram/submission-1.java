class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        - for each height in heights, check left + right
        - if the value is greater than or equal to height, keep going
        - if the value is lower, that means height cannot be the height for this rectangle anymore, so need to clauclate current area (right - left * height) and store if this is max
        - move to next height and repeat

        - the left & right boundaries are the first smaller heights of the current height
        - in the stack, we store the leftmost value the current height can extend to
        - then, we keep going to the right to find the rightmost value it can reach, then pop it from the tack & clauclate current area
        - values that are still in the stack means it can go all the way to the end
        */

        int res = 0;
        Stack<int[]> stack = new Stack<>(); // store [index, height]

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            int curHeight = heights[i];
            // while stack not empty AND current height < top of stack:
                // pop from stack
                // calculate area (popped height * (i - popped index))
                // update res
                // set start = popped index (current bar can extend back to here)
            while (!stack.isEmpty() && curHeight < stack.peek()[1]) {
                int[] pair = stack.pop();
                int curArea = (i - pair[0]) * pair[1];
                res = Math.max(res, curArea);
                start = pair[0];
            }

            // push [start, heights[i]] onto stack
            stack.push(new int[]{start, heights[i]});
        }

        // after loop, remaining bars in stack extend to the end
        // for each remaining: area = height * (heights.length - index)
        int area = 1;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            res = Math.max(res, cur[1] * (heights.length-cur[0]));
        }
        return res;
        
    }
}
