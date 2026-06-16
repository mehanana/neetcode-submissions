class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        /*
        - reminds me of 3sum
        - each point, we can choose to include the cur number, not include it at all (move to the next number)
        1. keep track of res (lol), current list, current target (target - sum), nums, current index
        2. in the helper, if index out of bounds -> see if target is 0, if so add to res, else return nothing
        3. check if target is 0, if so add to list, and if not, keep going on
        4. add curindex & call helper with cur index again
        5. remove cur index & call helper without cur index
        */

        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), 0, nums, target);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int index, int[] nums, int target) {
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
        backtrack(res, cur, index, nums, target-nums[index]);
        cur.remove(cur.size()-1);
        backtrack(res, cur, index+1, nums, target);
    }
}
