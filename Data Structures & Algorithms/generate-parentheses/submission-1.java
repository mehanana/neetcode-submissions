class Solution {
    public List<String> generateParenthesis(int n) {
        /*
        if n = 3
        ((( )))
        if we choose to add (, increase count by 1
        if we choose to add ), decrease count by 1
        count can't be less than 0 or more than n
        */
        List<String> res = new ArrayList<>();
        dfs(res, n, 0, "");
        return res;
        
    }
    private void dfs(List<String> res, int n, int count, String curString) {
        if (count < 0 || (curString.length() == n * 2 && count != 0)) {
            // ) was added with no prev (  or  it's not well formed string
            return;
        } else if (curString.length() == n * 2 && count == 0) {
            res.add(curString);
            return;
        }
        // String cur = curString;  --> strings are immutable so don't need this
        dfs(res, n, count+1, curString + "(");
        dfs(res, n, count-1, curString + ")");
    }

}
