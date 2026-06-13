class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        max heap since we want the 2 largest values
        - use neg versions since that would make it the most min, which means the pos versions will be the most max
        - check if heap size is 2 or more, if so, take these 2 and smash, if we're left with 0, keep moving, else add cur value to the heap
        - repeat until 1 stone left (heap size == 1)
        */

        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue();
        for (int i : stones) {
            heap.offer(0-i);
        }

        while (heap.size() > 1) {
            int x = 0-heap.poll();
            int y = 0-heap.poll();
            int sum = y - x;
            if (sum != 0) {
                heap.offer(0-Math.abs(sum));
            }
        } 

        return heap.isEmpty() ? 0 : 0-heap.poll();

        
    }
}
