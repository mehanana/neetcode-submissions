class WordDictionary {
    Node start;

    public WordDictionary() {
        this.start = new Node();
    }

    public void addWord(String word) {
        Node cur = start;
        for (char c : word.toCharArray()) {
            if (c != '.') {
                cur.characters.putIfAbsent(c, new Node());
                cur = cur.characters.get(c);
            }
            
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        /*
        - go through each char in word
        - if the char is *, then go through all children
        */

       return dfs(word, 0, start);

    }

    private boolean dfs(String word, int index, Node node) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (Node child : node.characters.values()) {
                if (dfs(word, index + 1, child)) return true;  // try each child
            }
            return false;
        } else {
            Node next = node.characters.get(c);
            if (next == null) return false;
            return dfs(word, index + 1, next);
        }
    }

}

class Node {
    Map<Character, Node> characters;
    boolean isWord;

    public Node() {
        characters = new HashMap();
        isWord = false;
    }
}
