class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
            c r a b t
        c 0 1 1 1 1 1
        a 0 1 1 2 2 2
        t 0 1 1 2 2 3

        text1 text2
        */

        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int c = 0; c < memo[0].length; c++) {
            memo[0][c] = 0;
        }
        for (int r = 0; r < memo.length; r++) {
            memo[r][0] = 0;
        }

        for (int r = 1; r < memo.length; r++) {
            for (int c = 1; c < memo[0].length; c++) {
                int rIndex = r-1;
                int cIndex = c-1;
                if (text1.charAt(rIndex) == text2.charAt(cIndex)) {
                    memo[r][c] = memo[r-1][c-1] + 1;
                } else {
                    memo[r][c] = Math.max(memo[r][c-1], memo[r-1][c]);
                }
            }
        }

        return memo[text1.length()][text2.length()];
    }
}
