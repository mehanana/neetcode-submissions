/*
class Solution {
    HashMap<Integer, List<Integer>> nodes = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        /*
        redundant connection = cycle
        - find the cycle, you find the redundant connection

        - but, you want to return the last one found in edges, a little confused on how to do this part
        */
/*
        for (int i = 1; i <= edges.length; i++) {
            nodes.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }

        for (int i = 1; i <= nodes.size(); i++) {
            int[] res = dfs(i, -1);
            if (!Arrays.equals(res, new int[]{-1, -1})) {
                return res;
            }
        }
        return new int[]{-1, -1};
        
    }

    private int[] dfs(int node, int prev) {
        if (cycle.contains(node)) {
            return new int[] {node, prev};
        }
        cycle.add(node);
        visited.add(node);
        List<Integer> curNodes = nodes.get(node);
        for (int i : curNodes) {
            int[] res = dfs(i, node);
            if (!Arrays.equals(res, new int[]{-1, -1})) return res;
        }
        cycle.remove(node);
        return new int[] {-1, -1};
    }


}
*/

class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;  // each node is its own parent initially
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;  // this edge connects two already-connected nodes → redundant
            }
        }
        return new int[]{-1, -1};
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    private boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false;  // already in same component → cycle

        // union by rank — attach smaller tree under larger
        if (rank[px] > rank[py]) parent[py] = px;
        else if (rank[px] < rank[py]) parent[px] = py;
        else { parent[py] = px; rank[px]++; }
        return true;
    }
}