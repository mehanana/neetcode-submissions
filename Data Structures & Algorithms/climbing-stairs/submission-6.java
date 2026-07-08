class Solution {
    /*
    step number:
    1 2 3
    
    ways:
    1 2 3
    1 3
    2 3
    */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;

        int cur = 3;
        while (cur <= n) {
            int temp = second;
            second = first + second;
            first = temp;
            cur++;
        }
        return second;
        
    }
}
