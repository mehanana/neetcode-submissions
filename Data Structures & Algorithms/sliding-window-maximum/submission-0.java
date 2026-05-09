class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        [1  2  1] 0  4  2  6        2
         1 [2  1  0] 4  2  6        2
         1  2 [1  0  4] 2  6        4
         1  2  1 [0  4  2] 6        4
         1  2  1  0 [4  2  6]       6

        - first window --> find the max + index of the max
        - next window --> compare the new added value to the index of the max (if it's still in the window)
            - if this new value is greater than the current max, store this index as the maxIndex
        - if the maxIndex is out of the window

        - keep track of the max indexes in a deque
        - append if the current index is greater than the front (or if the front is out of scope) and pop if the current index is greater than any other index
        */
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);
            if (l > deque.getFirst()) {
                deque.removeFirst();
            }
            if ((r+1) >= k ) {
                result[l] = nums[deque.getFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
