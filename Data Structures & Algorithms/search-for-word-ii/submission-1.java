class Solution {
    /*
    - store all words as a trie
    - go through each row/col and see if a word can be formed
        - if the letter matches any of the children, try all adjacent letters, and once one matches, add to list. if end of board is reached or no match, move to next start tile

    - keep track of cells that have been visited because can't use it more than once
    */
    Node root = new Node('\u0000');
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<>();
        toTrie(words);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Node curr = root;
                dfs(board, visited, row, col, res, curr);
            }
        }
        return res; 
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int col, List<String> res, Node curr) {
        if (row < 0 || col < 0 || row > board.length-1 || col > board[0].length -1) {
            return;
        }
        if (!visited[row][col]) {
            char c = board[row][col];
            if (curr.children[c-'a'] != null) {
                curr = curr.children[c-'a'];
                visited[row][col] = true;
                if (curr.isWord) {
                    res.add(curr.word);
                    curr.isWord = false;
                }
                dfs(board, visited, row+1, col, res, curr);
                dfs(board, visited, row, col+1, res, curr);
                dfs(board, visited, row-1, col, res, curr);
                dfs(board, visited, row, col-1, res, curr);
                visited[row][col] = false;
            }
        }
        
    }

    private void toTrie(String[] words) {
        for (String word : words) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children[c-'a'] == null) {
                    curr.children[c-'a'] = new Node(c);
                }
                curr = curr.children[c-'a'];
            }
            curr.setTrue(word);
        }
    }
}

class Node {
    char c;
    Node[] children;
    boolean isWord;
    String word;

    public Node(char c) {
        this.c = c;
        this.children = new Node[26];
        this.isWord = false;
    }

    public void setTrue(String word) {
        this.isWord = true;
        this.word = word;
    }
}