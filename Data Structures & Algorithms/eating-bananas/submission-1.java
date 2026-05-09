class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        need to eat all piles in h hours
        can finish whole pile in 1 hr, but need to wait for next hour to start next pile
        return the minimum rate of bananas to eat per hour to finish all piles before the time limit's over

        can go from 1 - highest value in pile
        check how long it will take to eat all bananas --> if less time, store the rate and go through the binary search and see if there's a lower rate we can use
        return the lowest number

        how to figure out how long it takes to eat all bananas?
        */

        
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }

            if (totalTime > h ) {
                left = mid + 1;
            } else {
                result = Math.min(result, mid);
                right = mid - 1;
            }
        }
        return result;
    }
}
