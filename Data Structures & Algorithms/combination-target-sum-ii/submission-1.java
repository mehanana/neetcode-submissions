class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, res, subset, candidates, 0, target);
        return res;
    }

    private void helper(int index, List<List<Integer>> res, List<Integer> subset, int[] candidates, int sum, int target) {
        if (target == sum) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (sum > target || index >= candidates.length) {
            return;
        }
        subset.add(candidates[index]);
        helper(index+1, res, subset, candidates, sum + candidates[index], target);
        subset.remove(subset.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index+1]) {
            index++;
        }
        helper(index+1, res, subset, candidates, sum, target);
    }
}
