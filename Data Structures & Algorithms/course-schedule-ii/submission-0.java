class Solution {
    /*
    similar to the prev one where if a cycle is found, return empty int[]
    if not, add to the list, but how to add in right order?
    - dfs, go to end of the chain (last thing that has no prereqs) and a
    */
    HashMap<Integer, List<Integer>> prereqs = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // put everything into hashmap that maps course to prereqs
        for (int i = 0; i < numCourses; i++) {
            prereqs.put(i, new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            prereqs.get(req[0]).add(req[1]);
        }


        List<Integer> output = new ArrayList<>();

        int[] res = new int[numCourses];
        int index = res.length - 1;
        // dfs through and add to list
        for(int i = 0; i < res.length; i++) {
           if (!dfs(i, output)) {
                return new int[0];
            }
        }

        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }
        return res;
    }

    private boolean dfs(int crs, List<Integer> output) {
        if (cycle.contains(crs)) {
            return false;
        }
        if (visited.contains(crs)) {
            return true;
        }

        cycle.add(crs);
        for (int pre : prereqs.get(crs)) {
            if (!dfs(pre, output)) {
                return false;
            }
        }
        cycle.remove(crs);
        visited.add(crs);
        output.add(crs);
        return true;
    }
}
