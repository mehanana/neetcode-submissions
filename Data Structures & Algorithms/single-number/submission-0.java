class Solution {
    public int singleNumber(int[] nums) {
        /*
        XOR --> when 2 identical numbers are XORed, they cancel out, resulting in 0
        - so XOR the entire array and the result will be teh number that only appears once
        - if XOR is false, res = num1 + num2
        - if XOR is true, res = res - numThatMatched

        res = 0

        i=4:  res = 0 ^ 4 = 4
        i=1:  res = 4 ^ 1 = 5
        i=2:  res = 5 ^ 2 = 7
        i=1:  res = 7 ^ 1 = 6   ← the second 1 "cancels" the first
        i=2:  res = 6 ^ 2 = 4   ← the second 2 "cancels" the first
        */

        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
        
    }
}
