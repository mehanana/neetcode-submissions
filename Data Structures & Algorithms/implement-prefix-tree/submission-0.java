class PrefixTree {
    private Node root;

    public PrefixTree() {
        this.root = new Node('\u0000');
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new Node(c);
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;

    }
}

class Node {
    public char c;
    public boolean isWord;
    public Node[] children;

    public Node (char c) {
        this.c = c;
        this.isWord = false;
        this.children = new Node[26];
    }
}
