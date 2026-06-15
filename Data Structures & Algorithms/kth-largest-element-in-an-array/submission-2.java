class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        min heap and add nums to it
        - pop as minheap size is k
        */

        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();

        for (int i : nums) {
            minheap.offer(i);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        return minheap.poll();

        
    }
}
