class Solution {
    public int getSum(int a, int b) {
        /*
        doesn't work : 
        if they're two different numbers, then xor
        if they're the same, then double it
        
        if (a == b) {
            return a * 2;
        } else {
            return a ^ b;
        }
        */

        while (b != 0) {
            int carry = (a & b) << 1;  // compute carry
            a = a ^ b;                  // add without carry
            b = carry;                  // carry becomes next b
        }
        return a;
        
    }
}
