class LRUCache {
    /*
    least recently used one gets pushed out of the list
    - hashmap to keep track of key + values
    - how to keep track of what was most recently used?
        - when get/put called on a key, add key value pair to a list (double linked)
    - remove from head of list

    there's a LinkedHashMap class we could use
    */

    private HashMap<Integer, Node> pairs;
    private int capacity;
    private Node left;
    private Node right;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        pairs = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert (Node node) {
        Node prev = this.right.prev;
        node.next = this.right;
        node.prev = this.right.prev;
        prev.next = node;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (pairs.containsKey(key)) {
            Node node = pairs.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (pairs.containsKey(key)) {
            remove(pairs.get(key));
        }
        Node newNode = new Node(key, value);
        pairs.put(key, newNode);
        insert(newNode);
        if (pairs.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            pairs.remove(lru.key);
        }
        
    }
}

public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
