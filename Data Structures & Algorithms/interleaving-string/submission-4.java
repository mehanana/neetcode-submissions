class Solution {
    HashMap<String, Boolean> memo = new HashMap(); // i + j -> true/false
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        i -> s1
        j -> s2
        k -> s3

        go through k, if i or j match, increase that, if neither match, return false
        but if i & j match, gotta try both ways --> store in hashmap, increase i in one way, increase j other way
        if k gets to end, return true (if i & j are also at the end, else return false)
        */
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return dfs(s1, s2, s3, 0, 0);

        
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j) {
        if (i + j >= s3.length()) {
            return true;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
      
        boolean matchS1 = i < s1.length() && s1.charAt(i) == s3.charAt(i + j);
        boolean matchS2 = j < s2.length() && s2.charAt(j) == s3.charAt(i + j);

        boolean res = false;
        if (matchS1) {
            res = dfs(s1, s2, s3, i + 1, j);
        }
        if (matchS2) {
            res = res || dfs(s1, s2, s3, i, j + 1);
        }

        memo.put(key, res);
        return res;
    }
}
