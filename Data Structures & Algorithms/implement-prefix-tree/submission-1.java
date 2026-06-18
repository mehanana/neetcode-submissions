class PrefixTree {
    Node start;


    public PrefixTree() {
        this.start = new Node();
    }

    public void insert(String word) {
        Node cur = start;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node cur = start;
        for (char c : word.toCharArray()) {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return false;
            }
        }
        return cur.isEnd;


    }

    public boolean startsWith(String prefix) {
        Node cur = start;
        for (char c : prefix.toCharArray()) {
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return false;
            }
        }
        return true;

    }
}

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}
