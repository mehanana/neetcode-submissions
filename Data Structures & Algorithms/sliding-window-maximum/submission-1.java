class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        - heap with index + num
        - if left & right don't contain heap.pop (index part), then keep popping?

        - for each subarray, the moment we see the max, the elements before teh max will never matter because we're always shifting to the right and while the max is in the subarray, the ones to the left of the max can enver become the max
        */

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



        
    }
}
