class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        increasing order, cannot be the same index
        left = 0, right = length - 1
        1,2,3,4 --> l = 0, r = 3 --> curSum = 1+4 = 5 > 3 (target) --> r--
                    l = 0, r = 2 --> curSum = 1+3 = 4 > 3 --> r--
        */

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int curSum = numbers[left] + numbers[right];
            if (curSum == target) {
                return new int[]{left+1, right+1};
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left - 1, right};
        
    }
}
