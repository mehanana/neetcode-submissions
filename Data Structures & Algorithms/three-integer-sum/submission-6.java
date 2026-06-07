class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        - sort nums
        - for each num in nums, look at the rest of nums and see if they make a sum of 0 with num, if yes add to the list
        - if not and it's too low, increase the left. else decrease right. for both, do this until the new left != old left (or right)
        */

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left < right && right < nums.length) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(new ArrayList(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left-1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right+1] == nums[right]) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
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
