class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        /*
        - go through s
        - if matches with first letter t
            - repeat going through rest of s and rest of t
        - if end of t reached, add 1
        - keep going through s to find more start values
        */

        memo = new int[s.length()][t.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(s, t, 0, 0);
        
    }

    private int dfs(String s, String t, int sIndex, int tIndex) {
        if (tIndex >= t.length()) {
            return 1;
        }

        if (sIndex >= s.length()) {
            return 0;
        }

        if (memo[sIndex][tIndex] != -1) {
            return memo[sIndex][tIndex];
        }

        int count = 0;
        if (s.charAt(sIndex) == t.charAt(tIndex)) {
            count = dfs(s, t, sIndex+1, tIndex+1) + dfs(s, t, sIndex + 1, tIndex);
        } else {
            count = dfs(s, t, sIndex+1, tIndex);
        }

        memo[sIndex][tIndex] = count;
        return count;
    }
}
