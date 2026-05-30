class Solution {
    public int reverseBits(int n) {
        /*
        1. divide by 2 to get the last digit
        2. shift to move to next bit
        3. shift res and place bit into it
        */
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n >>>= 1; 
            res = (res << 1) | bit;
        }
        return res;
        
    }
}
