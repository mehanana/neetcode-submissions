class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        check every porition of the word form the beigning that matches smth in wordDict
        repeat

        OR

        check every word in word dict and see if it matches the first part of s, then repeat with the rest of s
        */

        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for (int i = s.length(); i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i+w.length()).equals(w)) {
                    dp[i] = dp[i+w.length()];
                }
                if (dp[i]) {
                    break;
                } 
            }
        }
        return dp[0];
        
    }
}
