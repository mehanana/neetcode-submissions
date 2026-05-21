class Solution {
    public int climbStairs(int n) {
        /*
        each time, take either 1 or 2 steps (pick one)
        if cur == n, add to count
        if cur > n, add 0
        if cur < n, repeat
        */
        
        //return dfs(n, 0);
        
        /*
        Dynamic Programming:
        - you get subproblems from 0,1,2,3,4,5
        - cache result (memoization)
        - result at 0 depends on result at 1, which depends on 2, etc. until base case

        bottom up approach - fibonacci sequence:
        - start at base case (n = 5) => 1 way to get to 5
        - start at 4 => 1 way to get to 5
        - start at 3 => waysAt4 + waysAt5 = 1 + 1 = 2
        - start at 2 => waysAt3 + waysAt4 = 2 + 1 = 3
        - start at 1 => waysAt2 + waysAt3 = 3 + 2 = 5
        - start at 0 => waysAt1 + waysAt2 = 5 + 3 = 8 -> answer

        - each value in answerArray depends on the 2 answers after it
        - so really only need to store the 2 values (int one and int two)
        - then after computing, shift the values over by 1
        */
        int one = 1;
        int two = 1;
        for (int i = 0; i < n-1; i++) {
            int temp = one;
            one = one + two;
            two = temp; 
        }
        return one;
           
    }
    /*
    public int dfs(int n, int cur) {
        if (cur >= n) return cur == n ? 1 : 0;
        return dfs(n, cur+1) + dfs(n, cur+2);
    }
    */
    
}
