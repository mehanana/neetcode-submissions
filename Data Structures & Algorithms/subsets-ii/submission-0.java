class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        how to avoid problem of duplicate subsets?
        */
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> subset, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(res, nums, subset, index+1);
        subset.remove(subset.size() - 1);
        while (index < nums.length - 1 && nums[index] == nums[index+1]) {
            index++;
        }
        dfs(res, nums, subset, index+1);
    }
}
