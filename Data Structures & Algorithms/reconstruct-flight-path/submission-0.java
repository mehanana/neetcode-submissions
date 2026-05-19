class Solution {
    HashMap<String, PriorityQueue<String>> flights = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        /*
        course scheduler again but this time, it's directed

        map: airport → min-heap of destinations
        DFS from "JFK":
            while there are destinations from current airport:
                pop the smallest destination, recurse into it
            add current airport to FRONT of result
        */
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            flights.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }

        List<String> res = new ArrayList<>();

        dfs("JFK", flights.get("JFK"), res);
        return res;
    }

    private void dfs(String start, PriorityQueue<String> dests, List<String> res) {
        while (!dests.isEmpty()) {
            String curDest = dests.poll();
            dfs(curDest, flights.getOrDefault(curDest, new PriorityQueue<>()), res);
        }
        res.add(0, start);
    }
}
