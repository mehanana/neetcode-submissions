class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        brute force = start at index 0 and traverse through array
        - then keep going until you find value that's bigger and keep track of how many you see
        - then go to next index and traverse through array, if the subsequence is bigger, replace count
        - return count after all subsequences done

        dp?:
        - for each index in nums, cache the length of the subsequence that can be formed with this number
        eg [9 1 4 2 3 3 7]
        dp [1 4 2 3 2 2 1]
        - if nums[i] < nums[i+1] => dp[i] = 1 + dp[i+1]
        - dp[2] has the biggest value, so that's what we return 


        - actually, the dp should store the lenght of the subsequenece that ends with nums[i]
        eg [9 1 4 2 3 3 7]
        dp [1 1 2 2 3 3 4]
        - dp[i] = max(dp[j] + 1) for all j < i where nums[j] < nums[i]
        - base case = dp[i] = 1
        - return max of dp at the end (keep track of this ig)
        */

        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
        
    }
}
