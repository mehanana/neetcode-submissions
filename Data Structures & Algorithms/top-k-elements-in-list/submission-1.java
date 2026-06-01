class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        - hashmap to count num and amount of times it appears
        - heap to keep track of the value and how many times its been seen (sorted by num times)
        - return the top k from min heap
        */

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            minheap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (minheap.size() > 0) {
            res[index] = minheap.poll()[1];
            index++;
        }
        return res;
    }
}
