class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
        smallest (x1-x2)^2 + (y1-y2)^2 = closest to the origin
        - want a min heap cuz we want to choose k smallest distance

        1. go through each value in points
        2. calculate distance
        3. put in min heap
        4. if min heap size > k, remove 1
        5. repeat until all values are seen
        6. return list of points

        time & space complexity = O(m) where m is length of points
        - new int[] stores distance, x1, and y1

        */

        // this is how to make sure we're using the right value to compare
        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            Comparator.comparing(a -> a[0])
        );

        for (int[] i : points) {
            int distance = i[0]*i[0] + i[1]*i[1];
            minheap.offer(new int[] {distance, i[0], i[1]});
        }

        int[][] res = new int[k][2];
        int count = 0;
        while (count < k) {
            int[] cur = minheap.poll();
            res[count] = new int[] {cur[1], cur[2]};
            count++;
        }

        return res;
        

    }
}
