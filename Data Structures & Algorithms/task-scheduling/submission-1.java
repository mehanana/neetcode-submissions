class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        aaa bb cc   n=1
        3   2  1
        - only care about counts now
        - process the more frequent one first

        - use max heap to find most frequent ones
        - pop the max
        increase cur time by 1
        - change this count
        - add this & time available (curtime+n) to process again to a queue
        repeat
        if top of queue time = curtime, add to heap again
        */

        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
        int[] count = new int[26];
        for (char c : tasks) {
            count[c-'A']++;
        }

        for (int i : count) {
            if (i > 0) {
                maxheap.offer(0-i);
            }
        }

        int curTime = 0;
        Queue<int[]> store = new ArrayDeque<int[]>();
        while (!maxheap.isEmpty()|| !store.isEmpty()) {
            curTime++;
            if (!store.isEmpty() && store.peek()[1] == curTime) {
                maxheap.offer(store.poll()[0]);
            }
            if (!maxheap.isEmpty()) {
                int cur = maxheap.poll();
                cur++;
                if (cur == 0) {
                    continue;
                }
                store.offer(new int[]{cur, curTime+n+1});

            }
            
        }
        return curTime;
 
        
    }
}
