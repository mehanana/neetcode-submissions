class LRUCache {
    /*
    - understand linked list, but a little confused on how to do this
    - double linked list !!!

    need to remember order of the operations done
    - hashmap to look up value of every key in O(1) time
    - left side = least recently used
    - right side = most recently used
    - with double linked list, it's easy to reorder the values by updating the pointers
    
    - built in = LinkedHashSet
    */
    private int capacity;
    HashMap<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        left.next = right;
        right.prev = left;
        
    }

    private void remove(Node node) {
        Node curLeft = node.prev;
        Node curRight = node.next;

        curLeft.next = curRight;
        curRight.prev = curLeft;
    }

    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            // update nodes to make this most recent
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        } else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node keyValue = new Node(key, value);
        cache.put(key, keyValue);
        insert(keyValue);
        if (cache.size() > this.capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    
}

class Node {
        int val;
        int key;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
            this.prev = null;
            this.next = null;
        }

    }
