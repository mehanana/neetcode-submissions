class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(0, nums, subset, res, 0, target);
        return res;
    }

    private void helper(int index, int[] nums, List<Integer> subset, List<List<Integer>> res, int sum, int target) {
        /*
        if (index >= nums.length) {
            if (sum == target) {
                res.add(new ArrayList<>(subset));
            }
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (sum < target) {
            subset.add(nums[index]);
            helper(index, nums, subset, res, sum+nums[index], target);
            subset.remove(subset.size() - 1);
            helper(index+1, nums, subset, res, sum, target);
        } else {
            helper(index+1, nums, subset, res, sum, target);
        }   
        */

        // cleaner version
        if (sum == target) {
        res.add(new ArrayList<>(subset));
        return;
    }
    if (index >= nums.length || sum > target) {
        return;
    }

    // include
    subset.add(nums[index]);
    helper(index, nums, subset, res, sum + nums[index], target);  
    subset.remove(subset.size() - 1);

    // skip
    helper(index + 1, nums, subset, res, sum, target);  
    }
}
