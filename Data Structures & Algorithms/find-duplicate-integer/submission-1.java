class Solution {
    public int findDuplicate(int[] nums) {
        /*
        originally thought of using a set, but that's not O(1) extra space
        linked list, but dk how that works with this

        looked at solution:
        - each number in the list is between 1-n (length of list)
        - so this means we can use the value to go to that index
        - for each value, we go to that and change the value there, but this would change nums

        - using slow and fast pointers, but need to watch solution video
        */

/*
        Set<Integer> result = new HashSet<>();
        for (int i : nums) {
            if (result.contains(i)) {
                return i;
            } else {
                result.add(i);
            }
        }

        return -1;
        */

        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2) {
                return slow;
            }

        }
        
    }
}
