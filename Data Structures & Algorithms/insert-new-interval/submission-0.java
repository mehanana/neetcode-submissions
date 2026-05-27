class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*
        brute force?
        - go through int[] interval
        - if interval[0] < newinterval[0] && interval[1] > newInterval[0] --> need to merge
        - now take this new interval (if merged), and compare to the next one and repeat steps until all intervals are checked

        overlap
        [0 3] --> 0 < 1 < 3
        [1 4]

        [0 3] --> 0 < 1 && 2 < 3
        [1 2]

        [0 3]
        [2 4]
        */
        List<int[]> resList = new ArrayList<>();
        int[] toCompare = newInterval;

        for (int[] curInterval : intervals) {
            if (curInterval[1] < toCompare[0]) {
                resList.add(curInterval);
            } else if (curInterval[0] > toCompare[1]) {
                resList.add(toCompare);
                toCompare = curInterval;
            } else {
                toCompare = new int[]{Math.min(curInterval[0], toCompare[0]), Math.max(curInterval[1], toCompare[1])};
            }
        }
        resList.add(toCompare);

        return resList.toArray(new int[resList.size()][]);

        
    }
}
