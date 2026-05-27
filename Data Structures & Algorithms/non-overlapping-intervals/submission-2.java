class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        - have list that keeps track of intervals already seen
        - if the curretn interval[0] >= firstInterval[1], then add to the list

        [1 2]
        [2 4]
        [1 4]

        [1 100]
        [11 22]
        [1 11]
        [2 12]

        - else that means there's an overlap and we need to remove it
        */
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] toCompare = intervals[0];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] >= toCompare[1]) {
                toCompare = current;
            } else {
                toCompare = toCompare[1] < current[1] ? toCompare : current;
                count++;
            }

        }
        return count;
        
    }
}
