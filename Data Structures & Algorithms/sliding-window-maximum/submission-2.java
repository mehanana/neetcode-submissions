class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        - store a heap of max values in the range 0-k
        - store the top value in int[] res
        - when we increase left & right by 1, remove left from heap and add right to the heap
        - repeat until we reach end of array

        1 2 3 4; k=3
        1st window - 1 2 3 : scan through each element, you get 3 is the max, add to output
        2nd window - 2 3 4 : scan through each element, you get 4 is the max, add to output
            - 2 is part of window, but yk 3 is greater, so why check it again?
            - so actually, don't even look at the 2 when scanning through this time, just check 3 & 4
        
        - add to deque in decreasing order
        - when we reach a value that's greater than the rightmost position (top) of the deque, pop the top until the top > curValue
        - then add the new value to the top of the deque
        - also need to remove the value at left when we move the window
        
        - to the output array, we add the topmost value of the deque (largest val)
        */
        // contain indeces instead of values
        Deque<Integer> q = new LinkedList(); 
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            // while lower numbers exist in deque
            while (!q.isEmpty() && nums[q.getLast()] < nums[right]) {
                q.removeLast();
            }
            // then add current value
            q.addLast(right);
            // remove left most index
            if (left > q.getFirst()) {
                q.removeFirst();
            }
            // edge case - check if window is atleast size k
            if (right - left + 1 == k) {
                res[left] = nums[q.getFirst()];
                left++;
            }
            right++;
        }
        return res;
























        /*
        - heap with index + num
        - if left & right don't contain heap.pop (index part), then keep popping?

        - for each subarray, the moment we see the max, the elements before teh max will never matter because we're always shifting to the right and while the max is in the subarray, the ones to the left of the max can enver become the max
        */
        /*

        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;
        while (r < n) {
            // while smaller values exist in the queue
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            // then add new vlaue to queue
            q.addLast(r);

            // if left value is out of bounds, remove it
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // make sure window is at least size k to add it to the output
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return output;
        */



        
    }
}
