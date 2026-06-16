class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*
        - im thining simialr solution as last time but sort candidates and increase index until candidates[index] != cur
        - could create set, but that's extra space
        */

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList();
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int target, int index) {
        if (index >= nums.length) {
            if (target == 0) {
                res.add(new ArrayList(cur));
            }
            return;
        }
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        cur.add(nums[index]);
        
        backtrack(res, cur, nums, target - nums[index], index+1);
        cur.remove(cur.size()-1);
        int newIndex = index;
        while (newIndex < nums.length && nums[newIndex] == nums[index]) {
            newIndex++;
        }
        backtrack(res, cur, nums, target, newIndex);
    }
}
