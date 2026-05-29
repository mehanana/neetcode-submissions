class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        /*
        1. sort (maybe by end)
        [1 3]   [1 3]
        [2 3]   [2 3]
        [3 7]   [6 6]
        [6 6]   [3 7]

        2. for each val in queries, go through intervals and see if an interval contains it
            - if it does, store the range in variable
            - if var is already set, choose teh smaller val
            - at the end of array, save this to res[]
            - if nothing found, store -1
        */
/*
BRUTE FORCE
_____________________________________________________________
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = queries[i];
            int curMax = Integer.MAX_VALUE;
            for (int[] interval : intervals) {
                if (interval[0] <= cur && interval[1] >= cur) {
                    curMax = Math.min(curMax, interval[1] - interval[0] + 1);
                }
            }
            if (curMax == Integer.MAX_VALUE) {
                curMax = -1;
            }
            res[i] = curMax;
        }
        return res;
        */
        
        // OPTIMAL HEAP SOLUTION
        /*
        if left value is greater than query, then the query cannot be in this interval
        - repeat through the intervals while the left value <= query & add the interval to the query (add the size of the query & right value to the min heap)
        - sort the query by the size
        - after going through the queries, add the minheap.poll() to the output array
        */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    
    }
}
