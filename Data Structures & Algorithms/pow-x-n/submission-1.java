class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        while (n != 0) {
            res = res * x;
            n--;
        }
        return res;
        /*
        2^10 = 2^5 * 2^5 = (2^2 * 2^2 * 2) * (2^2 * 2^2 * 2),
        */
        /*
        better solution:  
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double res = helper(x, Math.abs((long) n));
        return (n >= 0) ? res : 1 / res;
        */
        
    }

     private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = helper(x, n / 2);
        return (n % 2 == 0) ? half * half : x * half * half;
    }
}
