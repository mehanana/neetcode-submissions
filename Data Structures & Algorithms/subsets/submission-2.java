class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /*
        - for each number in nums, either add it to the set, or leave it from the set
        */
        
        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[index]);
        backtrack(res, cur, nums, index+1);
        cur.remove(cur.size() - 1);
        backtrack(res, cur, nums, index+1);
    }
}
