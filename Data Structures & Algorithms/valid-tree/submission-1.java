class Solution {
    HashMap<Integer, List<Integer>> nodes = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        /*
        no cycles and all nodes reached
        - check for cycles, if 1 detected, return false
        - also keep track of all nodes visited, and if it equals n in the end, return true
        */
        // put everything in hashmap for node to each connected node
        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList<>());
        }
        for (int[] pair : edges) {
            nodes.get(pair[0]).add(pair[1]);
            // undirected so need to add both ways
            nodes.get(pair[1]).add(pair[0]);
        }

        // dfs through each unvisited node
        for (int node = 0; node < n; node++) {
            // if cycle found
            if (!dfs(node, -1)) {
                return false;
            }
        }

        return visited.size() == n;
    }

    // also need to pass in prev node so it doesn't count the direction back to that
    private boolean dfs(int node, int prev) {
        if (cycle.contains(node)) {
            return false;
        }
        if (visited.contains(node)) {
            return true;
        }
        cycle.add(node);
        visited.add(node);
        List<Integer> curNodes = nodes.get(node);

        for (int i = 0; i < curNodes.size(); i++) {
            if (curNodes.get(i) == prev) {
                continue;
            }
            if (!dfs(curNodes.get(i), node)) {
                return false;
            }
        }
        
        cycle.remove(node);
        return true;
    }
}
