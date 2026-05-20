class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        time to take to get from 1 node to next
        find min time to reach all nodes; if all nodes aren't connected, return -1

        kruzgal's algorithm?
        Hashmap of node to list of connected nodes + times it took to get there (pair)

        also have dist[] where dist[i] is shortest distance from k to i (everything is infinity except dist[k] which is 0)
        start at first node, add all connections from this to next nodes
        then go to next node, add all ocnnections from this to next nodes, if connection already exists, pick smaller one
        do this until all nodes reached and return the lowest value?

        use min-heap:
        1. Add (0, k) to min-heap  [distance, node]
        2. Poll the smallest distance node
        3. For each neighbor, if dist[neighbor] can be improved, update and add to heap
        4. Repeat until heap empty
        5. Return max of dist[] — that's how long until ALL nodes receive signal
        6. If any node is still infinity, return -1
        */

        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            edges.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparing(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0]; //curr[] comes from our hashmap, so it's weight then node
            int n1 = curr[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            t = w1;

            if (edges.containsKey(n1)) {
                for (int[] next : edges.get(n1)) {
                    int n2 = next[0]; // next comes from edges so it's node then weight
                    int w2 = next[1];
                    if (!visited.contains(n2)) {
                        minHeap.offer(new int[] {w1+w2, n2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
        
    }
}
