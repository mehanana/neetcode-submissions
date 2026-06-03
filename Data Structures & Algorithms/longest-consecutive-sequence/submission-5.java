class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        1. add all values of nums to a set
        2. start at 1st value, if value+1 is in set, add to counter
        3. keep doing this until value+1 is not in set
        4. then move onto next value
        */

        Set<Integer> seq = new HashSet();
        for (int i : nums) {
            seq.add(i);
        }
        int res = 0;
        for (int i : seq) {
            if (!seq.contains(i-1)) {
                int count = 1;
                int curValue = i;
                while (seq.contains(curValue+1)) {
                    curValue++;
                    count++;
                }
                res = Math.max(res, count);
            }
            
        }

        return res;






















        /*
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
        */
        
    }
}
