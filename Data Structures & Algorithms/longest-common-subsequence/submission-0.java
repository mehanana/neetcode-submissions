class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
          c a t
        c 1 1 1
        r 1 1 1
        a 1 2 2
        b 1 2 2
        t 1 2 3

        for each letter in text1, compare to letter in text2
        text1(0) == text2(0) --> dp[0][0] = 1
        - else dp[0][0] = 0
        text1(1) == text2(0) --> false so 0 + text1(0) + text2(0) (add the one to the left)


        */

        int[][] dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = 1 + (i > 0 && j > 0 ? dp[i-1][j-1] : 0);
                } else {
                    dp[i][j] = Math.max(
                        i > 0 ? dp[i-1][j] : 0,
                        j > 0 ? dp[i][j-1] : 0
                    );
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];


    }
}
