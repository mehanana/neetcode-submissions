class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        1. sort nums
        2. for each number, go through the numbers after it using left & right pointer starting from i+1 & nums.length-1
        3. if nums[i] + nums[left] + nums[right] = 0, store it
        4. if too high, right ---. if too low, left++
        5. when we do find a match, or when we're traversing through the outer loop, we also want to make sure that the number we're seeing hasn't already been seen (since no duplicates)
        */

        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) continue;
            int left = index+1;
            int right = nums.length-1;
            while (left < right) {
                if (nums[index] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    left++;
                    right--;
                    // make sure left != num before it
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // make sure right != num after it
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[index] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
                
                
            }

        }
        return res;



















        /*
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int num1 = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (num1 + nums[left] + nums[right] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (num1 + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
        */
        
    }
}
