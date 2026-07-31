class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;

        



































        
        /*
        open before closed
        a star can be open, close, or nothing
        - dfs would be to do all 3 options and see if any path results in true
        - num left has to be greater than or equal to right parentheses

        - keep track of VALID never negative, if this ever happens, reset to 0) max left parentheses and min left parentheses we could have based on what we choose at each decision for the wildcard
        */

/*
        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        } 
        return leftMin == 0;
*/

        
    }
}
