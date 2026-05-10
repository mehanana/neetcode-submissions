class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        a b c --> 3 cycles
        a b c n=3 --> 4 cycles cuz a b c idle a

        thinking smth like add to heap, if duplicate found -> see if heap size > n, if so add and if not wait before adding (like go through rest of array) or add idle if the array is done
        
        - start with most frequent task, then next frequent & repeat
        - store the frequency of each value in a maxheap
        - keep track of number of cycles so far
        - pop from maxheap, subtract 1 from it and add 1 to the cycles. if the value from the maxheap is not 0, add it to a queue (along with the cycle it can join at)
        - go to next value in maxheap, same steps. if the number of cycles now equals queue.pop()[1] (cycle it can join at), add it to the maxheap
        */

        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int c : count) {
            if (c > 0) {
                maxHeap.add(-c);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int cycle = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            cycle++;
            if (maxHeap.isEmpty()) {
                cycle = q.peek()[1];
            } else {
                int cur = maxHeap.poll() + 1;
                if (-cur > 0) {
                    q.add(new int[]{cur, cycle + n});
                }
            }
            
            if (!q.isEmpty() && q.peek()[1] == cycle) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return cycle;




        
    }
}
