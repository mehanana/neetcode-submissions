class MedianFinder {
    PriorityQueue<Integer> minheap; // stores 2nd half
    PriorityQueue<Integer> maxheap; // stores 1st half

    /*
    maxheap      minheap
    1 3           2
    */

    public MedianFinder() {
        minheap = new PriorityQueue<Integer>();
        maxheap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        maxheap.offer(0-num);
        if (maxheap.size() > minheap.size()+1) {
            minheap.offer(0 - maxheap.poll());
        }
        if (!maxheap.isEmpty() && !minheap.isEmpty() && (0-maxheap.peek()) > minheap.peek()) {
            int min = minheap.poll();
            int max = 0-maxheap.poll();
            maxheap.offer(0-min);
            minheap.offer(max);
        }
    }
    
    public double findMedian() {
        if (maxheap.size() > minheap.size()) {
            return (double) 0.0-maxheap.peek();
        } else {
            if (!minheap.isEmpty() && !maxheap.isEmpty()) {
                return (double) (minheap.peek() + (0.0-maxheap.peek())) / 2;
            }
            if (minheap.isEmpty()) {
                return 0.0-maxheap.peek();
            }
            if (maxheap.isEmpty()) {
                return minheap.peek();
            }
        }
        return -1.0;
    }
}
