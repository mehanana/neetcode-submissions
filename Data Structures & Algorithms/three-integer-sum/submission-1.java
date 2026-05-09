class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        returning the actual numbers, not indeces, which means i can sort
        */

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // -4,-1,-1,0,1,2

        for (int i = 0; i < nums.length; i++) {
            int curGoal = 0-nums[i];
            int left = i+1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (left < right) {
                if (nums[left] + nums[right] == curGoal) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] > curGoal) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;

    }
}
