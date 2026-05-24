class Solution {
    public boolean canPartition(int[] nums) {
        /*
        brute force = trying each possible partitioning and seeing if any equaled each other
        - break at index 0, then 1, etc. until nums.length / 2 was reached

        dp:
        dp[i] is the sum when partitioned at index i in nums
        eg [1 2 3 4]
        dp [1 3 ]

        - wait no can't do this cuz we can take any set of numbers

        - if sum is odd, return false
        - we are trying to find a subset equal to sum / 2

        decision tree:
        eg [1 2 3 4]
        sum = 10, trying to reach 5
        - take 1, sum is 4, so only options are 2 and 3
            - take 2 or 3, can't get to sum 5
        
        dp[i] stores what value is needed to get to sum/ 2?
        dp [4 3 2 1]?

        eg. [1 5 11 5], let's say we start at 1st value (1), and we know every other sums in the rest of the array
        for (t in subarray) {
            if (t == target) {
                return true;
            }
            if (1 + t == target) {
                return true;
            }
        }
        - work our way backwards and see how many possible sums we can create from this subarray (5) --> take it or leave it, so it's either 0, 5 (store in hashset)
        - now we go to 11, so set is {0, 5, 11, 16 (11+5)}
        - then we see 2nd 5, so set is {0, 5, 11, 16, 10, 21}
        - then we see 1, so set is {0, 5, 11, 16, 10, 21, 1, 6, 12, 17, 22}
        - if target is in set, return true, else return false

        */

        HashSet<Integer> dp = new HashSet<>();
        dp.add(0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            if (i == target) {
                return true;
            }
            HashSet<Integer> nextDP = new HashSet<>();
            for (int t : dp) {
                nextDP.add(t + nums[i]);
                nextDP.add(t);
            }
            dp = nextDP;
        }

        return dp.contains(target);
        
    }
}
