class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index >= nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        cur.add(nums[index]);
        backtrack(res, cur, nums, index+1);
        int newIndex = index;
        while (newIndex < nums.length && nums[newIndex] == nums[index]) {
            newIndex++;
        }
        cur.remove(cur.size()-1);
        backtrack(res, cur, nums, newIndex);
    }
}
