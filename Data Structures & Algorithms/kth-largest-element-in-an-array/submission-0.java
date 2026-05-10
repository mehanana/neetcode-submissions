class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        max heap --> add all values to it, then go through until you get k amount and return
        */

        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        for (int i : nums) {
            maxheap.add(-i);
        }

        for (int i = 0; i < k-1; i++) {
            maxheap.poll();
        }
        return -maxheap.poll();
        
    }
}
