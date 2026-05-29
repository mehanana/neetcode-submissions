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

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cur = queries[i];
            int curMax = Integer.MAX_VALUE;
            for (int[] interval : intervals) {
                if (interval[0] <= cur && interval[1] >= cur) {
                    curMax = Math.min(curMax, interval[1] - interval[0] +1);
                }
            }
            if (curMax == Integer.MAX_VALUE) {
                curMax = -1;
            }
            res[i] = curMax;
        }
        return res;
        
    }
}
