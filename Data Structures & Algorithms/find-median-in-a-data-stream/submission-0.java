class MedianFinder {
    /*
    - two heaps where the left one has values less than right heap
    - size of both heaps are always going to be approx equal
    - small heap = max heap
        - small heap can be bigger than large heap and if so, the median is smallheap.peek()
    - large heap = min heap
    - if both heaps are the same size, then the median is smallheap.peek() + largeheap.peek() / 2

    1. add value to small heap
    2. if smallheap.size() - largeheap.size() > 1 --> largeheap.add(smallheap.pop())

    */

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()
        ) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } else {
            return (double) largeHeap.peek();
        }
    }
}
