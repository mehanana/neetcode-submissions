class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        max heap --> add all values to it, then go through until you get k amount and return
        

        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        for (int i : nums) {
            maxheap.add(-i);
        }

        for (int i = 0; i < k-1; i++) {
            maxheap.poll();
        }
        return -maxheap.poll();
        */

        /*
        or just have min heap and if size > k, then the top (minimum) will be polled
        in the end, the top value will be the k largest since you're always removing the smallest value
        */
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i : nums) {
            minheap.offer(i);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        return minheap.peek();
        
    }
}
