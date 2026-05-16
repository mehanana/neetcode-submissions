/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        /*
        have hashmap of new node to old list of children
        add copy of node and node.children to the map
        then iterate through all children and do the same for each thing (if it doesn't already exist in the hashmap, so maybe use hashset?)

        then, go through each entry of hashmap, and for the list of children, make a new list with copies of children
        then save this in node.children
        */

        if (node == null) return null;
        HashMap<Node, Node> copies = new HashMap<>();
        return dfs(copies, node);
    }

    private Node dfs(HashMap<Node, Node> copies, Node cur) {
        if (copies.containsKey(cur)) return copies.get(cur);
        
        Node clone = new Node(cur.val);
        copies.put(cur, clone);
        
        for (Node neighbor : cur.neighbors) {
            clone.neighbors.add(dfs(copies, neighbor));
        }
        return clone;
    }
}