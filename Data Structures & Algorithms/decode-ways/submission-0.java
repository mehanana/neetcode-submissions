class Solution {
    public int numDecodings(String s) {
        /*
        s = "1012"
        10 1 2
        10 1 2
        - whenever there's a 0, it needs to be paired with the number before it since we can't start with 0

        */
        int count = 0;
        if (s.charAt(0) == '0') {
            return 0;
        }

        int one = 1;
        int two = 1;

        for (int i = 1; i < s.length(); i++) {
            int temp = 0;
            // single digit — valid if not '0'
            if (s.charAt(i) != '0') {
                temp += one;
            }
            // two digits — valid if between 10-26
            int twoDigit = Integer.parseInt(s.substring(i-1, i+1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                temp += two;
            }
            two = one;
            one = temp;
        }

        return one;
        
    }
}
