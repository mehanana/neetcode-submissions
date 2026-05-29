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
        
    }
}
