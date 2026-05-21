class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /*
        dijkstra's but keep track of min this time?
        also need to keep track of places visited so far and if num > k, return -1 (only if all paths explored)

        1. Add [0, src, 0] to min-heap  [cost, node, stops used]
        2. Poll cheapest
        3. If node == dst, return cost
        4. If stops > k, skip
        5. For each neighbor, add [cost + edge, neighbor, stops + 1]
        6. If heap empty, return -1        
        */


        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        dist[src][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int cst = top[0], node = top[1], stops = top[2];
            if (node == dst) return cst;
            if (stops == k || dist[node][stops + 1] < cst) continue;
            for (int[] neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;
        /*
        Bellman Ford Algorithm

        
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmpPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                if (prices[s] == Integer.MAX_VALUE) {
                    continue;
                }

                if (prices[s] + p < tmpPrices[d]) {
                    tmpPrices[d] = prices[s] + p;
                }
            }

            prices = tmpPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        */
    }

}
