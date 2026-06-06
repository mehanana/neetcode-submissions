class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        - rate k - 1 to biggest number in piles
        1. if piles > h, return false
        2. sort piles
        3. find mid and see if you can eat all bananas in h hours
        4. if no, increase left
        5. if yes, save this value and decrease right to see if we can find a better rate
        */
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length-1];
        int res = piles[piles.length-1];

        while (left <= right) {
            int mid = (right + left) / 2;
            int hours = 0;
            for (int num : piles) {
                hours += Math.ceil((double) num/mid);
            }
            if (hours <= h) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;


        
    }
}
