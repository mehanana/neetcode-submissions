class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);         

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(HashMap<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int next : graph.get(node)) {
            dfs(graph, next, visited);
        }
    }
}