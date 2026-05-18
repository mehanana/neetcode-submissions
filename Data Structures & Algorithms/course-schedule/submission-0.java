class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>(); // map each course to its prereqs
    private Set<Integer> visiting = new HashSet<>(); // store all courses along cur dfs path
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
        /*
        if there's ever a cycle, this means we can't finish
        - hash set to see what we've already seen so far
        */

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] req : prerequisites) {
            preMap.get(req[0]).add(req[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            // get the course + prereq
            // add the prereq to the set
            // find the prereq in the list
            // if not there, move to next item
            // if present, repeat
            if (!dfs(c)) {
                return false;
            }
        }   
        
        return true;
    }

    private boolean dfs(int crs) {
        if (visiting.contains(crs)) {
            return false; // cycle
        }
        visiting.add(crs);
        if (preMap.get(crs).isEmpty()) {
            visiting.remove(crs);
            return true;
        }
        for (int c : preMap.get(crs)) {
            if (!dfs(c)) {
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
