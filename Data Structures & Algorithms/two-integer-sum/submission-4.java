class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        - store index to target-nums[index] (actually lets do it the other way around)
        - if nums[i] exists in the hashmap, return i and hashmap.get(nums[i])
        */
        Map<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sums.keySet().contains(nums[i])) {
                return new int[]{sums.get(nums[i]), i};
            }
            sums.put(target-nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
