class Solution {
    public int[] twoSum(int[] nums, int target) {
        // will nums always be sorted?
        // left and right index, if sum is too high, move right pointer down
        // if sum is too low, move left pointer up

/*
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {left, right};
            }
        }

        return new int[] {left, right};
        */

        // nums[i] + nums[j] = target
        // what if instead it was nums[j] = target - nums[i]
        // for each index i, difference = target - nums[i] --> find difference in the hashmap

        Map<Integer, Integer> indexElement = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (indexElement.containsKey(difference)) {
                int j = indexElement.get(difference);
                if (i < j) {
                    return new int[] {i, j};
                } else {
                    return new int[] {j, i};
                }
                
            } else {
                indexElement.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
