class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        /*
        [1 3]
        [1 5]
        [6 9]
        [7 8]
        */

        List<int[]> res = new ArrayList<>();

        int[] toCompare = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            // check if they can't be merged
            /*
            [1 5] [6 9]
            toCompare[1] < current[0]
            */
            if (toCompare[1] < current[0]) {
                res.add(toCompare);
                toCompare = current;
            } else {
                toCompare[0] = Math.min(toCompare[0], current[0]);
                toCompare[1] = Math.max(toCompare[1], current[1]);
            }
        }
        res.add(toCompare);
        return res.toArray(new int[res.size()][]);
        
    }
}
