class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node('\u0000');
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, Node cur) {
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child : cur.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
        }
        return cur.isWord;
    }
}

class Node {
    char c;
    Node[] children;
    boolean isWord;

    public Node(char c) {
        this.c = c;
        this.children = new Node[26];
        this.isWord = false;
    }
}