class Solution {
    public int hammingWeight(int n) {
        /*
        if you AND n & n, result should be number of 1s
          1011
        & 0001 (only last digit will be 1 if there's a match)
        1011 % 2 --> returns 1 if the last bit is 1, 0 otherwise
        - after each time, take all bits and shift by 1 (bit manipulation)
        - then repeat

        - with integer division, you can just divide by 2 to get the same result (if you don't want to do bit manipulation)
        */     
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((1 << i & n) != 0) {
                res++;
            }
        }
        return res;   
        /*
        - when you subtract 1 from itself, we're getting rid of a bit
        - when we logic 'and' it with itself, we're removing the 1 bit, so then we have to add 1
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
        */


    }
}
