class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int remainder = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = digits[i] + remainder;
            if (i == digits.length-1) {
                cur++;
            }
            remainder = cur / 10;
            cur = cur % 10;
            res.add(cur);
        }
        if (remainder > 0) {
            res.add(remainder);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(res.size() - 1 - i);
        }
        return result;

        /*
        space saving solution

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;       // no carry, done early
            }
            digits[i] = 0;          // was 9, becomes 0, carry continues
        }
        // All digits were 9 (e.g. 999 -> 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
        */
        
    }
}
