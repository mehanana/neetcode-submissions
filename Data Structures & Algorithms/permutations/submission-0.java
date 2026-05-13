class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /*
        each entry in the result will be nums.length because we have to include all the numbers in nums
        */

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i : nums) {
            if (cur.contains(i)) {
                continue;
            } else {
                cur.add(i);
                dfs(res, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
