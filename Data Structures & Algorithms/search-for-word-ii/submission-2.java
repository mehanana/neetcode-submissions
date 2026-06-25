class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        /*
        - make trie for all the words
        - go through board, if board[row][col] in root.children, dfs through the board & the trie, if at any point we reach the end of a word, add the word to the list
        */
        
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                dfs(row, col, board, root, words);
            }
        }

        return res;
    }

    private void dfs(int row, int col, char[][] board, TrieNode node, String[] words) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '*' || node.children[board[row][col] - 'a'] == null) {
            return;
        }
        char temp = board[row][col];
        board[row][col] = '*';
        TrieNode prev = node;
        node = node.children[temp-'a'];
        if (node.idx != -1) {
            res.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            if (node.refs == 0) {
                node = null;
                prev.children[temp-'a'] = null;
                board[row][col] = temp;
                return;
            }
        }
        dfs(row + 1, col, board, node, words);
        dfs(row - 1, col, board, node, words);
        dfs(row, col + 1, board, node, words);
        dfs(row, col - 1, board, node, words);

        board[row][col] = temp;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;
    int refs = 0;

    public void addWord(String word, int i) {
        TrieNode cur = this;
        cur.refs++;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
            cur.refs++;
        }
        cur.idx = i;
    }
}
