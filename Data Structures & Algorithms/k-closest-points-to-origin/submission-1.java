class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
        make pair class that takes in int[][] for point, distance
        for each point, add new Pair(point, dist) to a heap
            - we want closest points, so use min heap
            - sort heap by dist
        - at the end, we can return the top k points (for int i = 0; i < k; i++) {
        minheap.pop().point}
        */

        PriorityQueue<Pair> minheap = new PriorityQueue<Pair>(Comparator.comparingInt(p -> p.dist));

        for (int[] p : points) {
            int dist = p[0] * p[0] + p[1] * p[1];
            minheap.offer(new Pair(p, dist));
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = minheap.poll().point;
        }
        return res;
    }

    class Pair {
        int[] point;
        int dist;

        public Pair(int[] point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }
}
