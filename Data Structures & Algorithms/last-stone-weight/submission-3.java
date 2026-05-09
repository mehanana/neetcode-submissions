class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        /*
        need max heap, but only have minheap so that's why everything's negative
        */
        for (int i : stones) {
            minHeap.offer(-i);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if (second > first) {
                minHeap.offer(first - second);
            }
        }
        minHeap.offer(0);
        return Math.abs(minHeap.peek());
    }
}
