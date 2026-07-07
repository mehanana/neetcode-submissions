class Solution {
    Map<Integer, List<Pair>> flightMap = new HashMap<>();
    Map<String, Integer> memo = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int[] flight : flights) {
            flightMap.computeIfAbsent(flight[0], key -> new ArrayList<>())
                     .add(new Pair(flight[1], flight[2]));
        }

        int result = dfs(src, dst, k, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(int start, int dst, int k, int count) {
        if (start == dst) {
            return 0;
        }
        if (count > k) {
            return Integer.MAX_VALUE;
        }

        String key = start + "," + count;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int best = Integer.MAX_VALUE;
        List<Pair> neighbors = flightMap.get(start);
        if (neighbors != null) {
            for (Pair p : neighbors) {
                int sub = dfs(p.dest, dst, k, count + 1);
                if (sub != Integer.MAX_VALUE) {
                    best = Math.min(best, sub + p.dist);
                }
            }
        }

        memo.put(key, best);
        return best;
    }
}


class Pair {
    int dest;
    int dist;

    public Pair (int dest, int dist) {
        this.dest = dest;
        this.dist = dist;
    } 
}