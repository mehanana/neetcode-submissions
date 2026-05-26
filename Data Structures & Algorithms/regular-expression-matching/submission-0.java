class Solution {
    // index for s, index for p, does it match
    Boolean[][] dp;;
    public boolean isMatch(String s, String p) {
        /*
        if . --> skip
        if * --> check index-1 and repeat until matches stop
        if .* --> keep skipping
        else, check if char matches and if not, return false
        */

        dp = new Boolean[s.length() + 1][p.length() + 1];

        return dfs(s, p, 0, 0);     
    }

    private boolean dfs(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean charMatch = i < s.length() && 
                           (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // zero times: skip x*
            // one+ times: current char matches, consume one s char
            dp[i][j] = dfs(s, p, i, j + 2) || 
                       (charMatch && dfs(s, p, i + 1, j));
        } else {
            dp[i][j] = charMatch && dfs(s, p, i + 1, j + 1);
        }

        return dp[i][j];
    }
}
