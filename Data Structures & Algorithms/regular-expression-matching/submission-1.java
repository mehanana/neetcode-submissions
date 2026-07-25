class Solution {
    HashMap<String, Boolean> cache = new HashMap();
    public boolean isMatch(String s, String p) {
        /*
        if char at s matches char at p, increase s index & p index by 1
        if char at p is ., move both by 1
        if next char at p is *, store this current char to be used OR don't need to use it
        */

        return dfs(s, p, 0, 0);
        
    }

    private boolean dfs(String s, String p, int i1, int i2) {
        if (i1 >= s.length() && i2 >= p.length()) {
            return true;
        }
        if (i2 >= p.length()) {
            return false;
        }

        String key = i1 + "," + i2;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        boolean match = i1 < s.length() && (s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '.');

        if (i2+1 < p.length() && p.charAt(i2+1) == '*') {
            // only use * for the rest if the cur char is a match
            cache.put(key, dfs(s, p, i1, i2+2) || (match && dfs(s, p, i1 + 1, i2)));
        } else {
            if (match) {
                cache.put(key, dfs(s, p, i1+1, i2+1));
            } else {
                cache.put(key, false);
            }
        }
        return cache.get(key);

    }
}
