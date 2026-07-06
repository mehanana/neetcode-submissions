class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap();
    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Integer>());
        }
        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i);
            }
        }
        return count;
    }

    private void dfs(boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : adj.get(i)) {
            dfs(visited, j);
        }
    }
}
