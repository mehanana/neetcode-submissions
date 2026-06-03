class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> allNums = new HashSet<>();
        for (int i : nums) {
            allNums.add(i);
        }
        int res = 0;
        for (int i : allNums) {
            if (!allNums.contains(i-1)) {
                int curValue = i;
                int length = 0;
                while (allNums.contains(curValue)) {
                    length++;
                    curValue++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
        
    }
}
