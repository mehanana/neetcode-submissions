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
        at first, i was confused on what the issue was
        - random and next point to the nodes in head, but we can't refer to any of those
        drk how to do it
        - looked at hint, i think we need to use a hash map of ListNode to copy Listnode
        */
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node temp = head;

        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
       while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
        
    }
}
