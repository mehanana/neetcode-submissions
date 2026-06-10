/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /*
        - for each node in head make a copy where its next values are currently empty
        - make a hashmap of new node to LinkedList next old node
        - then iterate through the hashmap and find the new node and make that the real next node
        */

        Node temp = head;
        HashMap<Node, Node> oldToNew = new HashMap();
        while (temp != null) {
            oldToNew.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        for (Node oldNode : oldToNew.keySet()) {
            Node oldNext = oldNode.next;
            Node oldRandom = oldNode.random;

            Node curNew = oldToNew.get(oldNode);
            curNew.next = oldToNew.get(oldNext);
            curNew.random = oldToNew.get(oldRandom);
        }
        
        return oldToNew.get(head);
        
    }
}
