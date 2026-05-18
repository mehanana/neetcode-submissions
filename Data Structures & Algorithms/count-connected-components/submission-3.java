class Solution {
    HashMap<Integer, List<Integer>> nodes = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        /*
        go through each node like before
        if we reach one that isn't already in the set (int the countCOmponents for loop), add 1 to count
        */

        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList<>());
        }

        for (int[] pair : edges) {
            nodes.get(pair[0]).add(pair[1]);
            nodes.get(pair[1]).add(pair[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i, -1);
            }
        }
        return count;

    }

    public void dfs(int node, int prev) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (int i = 0; i < nodes.get(node).size(); i++) {
            if (nodes.get(node).get(i) != prev) {
                dfs(nodes.get(node).get(i), node);
            }
        }
    }
}
