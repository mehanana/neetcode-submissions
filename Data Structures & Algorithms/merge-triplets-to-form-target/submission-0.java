class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*
        - at any point, if a triplet has a value greater than target, we'll never get the target (only things bigger)
            - so don't even consider this
        3 values in target
        x -> cna we match target[0]
        y -> can we match target[1]
        z -> cna we match target[2]

        iterate through each triplet t
        x is true if t[0] = target[0] && t[1] < target[1] && t[2] < target[2]
        y is true if same conditions, except t[1] == target[1], and same for z
        if all are true at any point, return true
        - else at the end return false
        */

        boolean x = false;
        boolean y = false;
        boolean z = false;
        for (int[] t : triplets) {
            if (t[0] == target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                x = true;
            }
            if (t[1] == target[1] && t[0] <= target[0] && t[2] <= target[2]) {
                y = true;
            }
            if (t[2] == target[2] && t[1] <= target[1] && t[0] <= target[0]) {
                z = true;
            }
            if (x && y && z) {
                return true;
            }

        }
        return false;
        
    }
}
