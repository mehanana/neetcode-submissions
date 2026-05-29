class Solution {
    public String multiply(String num1, String num2) {
        /* 
           123
         * 456
         ------

        6*3 + 6*20 + 6*100
        */

        // if zero, return itself
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // put the multiplied value in the num1Index + num2Index position in the result
        for (int i1 = 0; i1 < num1.length(); i1++) {
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int digit = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                res[i1 + i2] += digit; // add wtv is at this position first (in case there was a remainder from earlier)
                res[i1 + i2 + 1] += res[i1 + i2] / 10; // remainder
                res[i1 + i2] %= 10; // cur pos
            }
        }

        StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        // skip leading 0
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            result.append(res[i--]);
        }
        return result.toString();
    }
}
