class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        /*
        - insert
        - delete
        - replace

        - if end of word2 and there's still stuff in word1, delete is the only option
        - go through word1 & word2, when we find a char that's different, try insert delete and replace & keep track of the lowest amount & save this (hashmap? string index word1 + index word2 -> lowest val)

        */
        
        memo = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }

        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i1, int i2) {
        if (i1 >= word1.length() && i2 >= word2.length()) {
            return 0;
        }
        else if (i1 >= word1.length()) {
            return word2.length() - i2;
            
        }
        else if (i2 >= word2.length()) {
            return word1.length() - i1;
            
        }

        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }


        int res = 0;
        if (word1.charAt(i1) == word2.charAt(i2)) {
            res = dfs(word1, word2, i1+1, i2+1);
        } else {
            res = 1+Math.min(dfs(word1, word2, i1+1, i2), Math.min(dfs(word1, word2, i1, i2+1), dfs(word1, word2, i1+1, i2+1)));
        }

        memo[i1][i2] = res;
        return res;

    }
}
