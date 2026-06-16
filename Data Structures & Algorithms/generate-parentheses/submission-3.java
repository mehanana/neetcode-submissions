class Solution {
    public List<String> generateParenthesis(int n) {
        /*
        - if number of open < n & open > 0, can add either open or closed
        - if open = 0, can only add open
        - if length of cur string == n * 2, add to list
        */

        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String cur, int numOpen, int numClose, int n) {
        if (numOpen == n && numClose == n) {
            res.add(cur);
            return;
        }

        if (numOpen < n) {
            backtrack(res, cur + "(", numOpen + 1, numClose, n);
        }
        if (numClose < numOpen) {
            backtrack(res, cur + ")", numOpen, numClose + 1, n);
        }
    }
}
