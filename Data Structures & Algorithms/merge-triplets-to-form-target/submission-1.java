class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*
        - x y z will end up being the max of triplet[0], triplet[1], triplet[2] for all triplets
        - if we find a triplet that has targetX, targetY, or targetZ --> check if the other values are less than or equal to target as well
            - if yes, use it
            - if no, don't use it
        - at the end, see if we have the targets or not
        */

        int x = 0;
        int y = 0;
        int z = 0;

        int targetX = target[0];
        int targetY = target[1];
        int targetZ = target[2];

        for (int[] triplet : triplets) {
            int curX = triplet[0];
            int curY = triplet[1];
            int curZ = triplet[2];

            if (curX <= targetX && curY <= targetY && curZ <= targetZ) {
                x = Math.max(x, curX);
                y = Math.max(y, curY);
                z = Math.max(z, curZ);
            }
        }

        return x == targetX && y == targetY && z == targetZ;































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

/*
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
        */
        
    }
}
