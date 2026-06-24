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
    private HashMap<Node, Node> oldToNew = new HashMap();


    public Node cloneGraph(Node node) {
        /*
        - hashmap of node to list of adjacent nodes
        1 : 2
        2 : 1, 3
        3 : 2

        - then make new hashmap of where each old node gets turned into a new node
        - then, for each new node, map it to a list of adjacent new nodes (get the hashmap keys)
        - then return the copy of the given node
        */

        if (node != null) {
            if (oldToNew.containsKey(node)) {
                return oldToNew.get(node);
            }
            Node newNode = new Node(node.val);
            oldToNew.put(node, newNode);
            for (Node n : node.neighbors) {
                newNode.neighbors.add(cloneGraph(n));
            }
            return newNode;
        }
        return node;
        
        
    }
}