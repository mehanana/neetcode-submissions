class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        - each number is 1 greater than the previous
        - doesn't have to be next to each other
        - if the number 1 below is in the list, don't start counting because we know that's not the start of the longest sequence

        */

        HashSet<Integer> allNums = new HashSet();
        for (int num : nums) {
            allNums.add(num);
        }

        int res = 0;

        for (int num : allNums) {
            if (allNums.contains(num - 1)) {
                continue;
            }
            int cur = num;
            int count = 0;
            while (allNums.contains(cur)) {
                count++;
                cur++;
            }
            res = Math.max(res, count);
        }

        return res;
























        /*
        1. add all values of nums to a set
        2. start at 1st value, if value+1 is in set, add to counter
        3. keep doing this until value+1 is not in set
        4. then move onto next value
        */

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
