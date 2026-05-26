class Solution {
        HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        for each index in s3, can choose an index in s1 or s2
        aabbbbaa
        */
        // brute force
        // hwoever, greedy doesn't work here becuase if char at s1 and s2 match s3, then we always pick s1, but we could pick s2
        
        /*
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < s1.length() && j < s2.length() && index < s3.length()) {
            if (s1.charAt(i) == s3.charAt(index)) {
                index++;
                i++;
            } else if (s2.charAt(j) == s3.charAt(index)) {
                index++;
                j++;
            } else {
                return false;
            }
        }
        
        while (i < s1.length() && index < s3.length()) {
            if (s1.charAt(i) != s3.charAt(index)) { 
                return false;
            }
            i++;
            index++;
        }
        while (j < s2.length() && index < s3.length()) {
            if (s2.charAt(j) != s3.charAt(index)) { 
                return false;
            }
            j++;
            index++;
        }
        if (i < s1.length() || j < s2.length() || index < s3.length()) {
            return false;
        }
        return true;
        */
        if (s1.length() + s2.length() != s3.length()) return false;
        return dfs(s1, s2, s3, 0, 0);
        
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        int k = i + j;  // index in s3 is always i + j
        if (k == s3.length()) return true;
        
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);
        
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            res = dfs(s1, s2, s3, i + 1, j);
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res = dfs(s1, s2, s3, i, j + 1);
        
        memo.put(key, res);
        return res;
    }
}
