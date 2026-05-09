class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        1 5 6 10
        3 4

        1 2 3 3 4 5 6 10

        - first idea was finding median of each individual array, idk how that's helpful
        looking at hints:
        - lowk don't get it

        we have two lists [1 5 6 10] and [3 4]
        total length = 6; half of that is 3 (this is where the median would be if we combined the two lists)
        - take the shorter list [3 4] and find half of that --> index 0, val 3
        - in order to get 3 values on the left side of the median of both lists, we need 3 - 1 = 2 values from the second list --> index 1, val 5
        - now the values we have chosen are 1 & 5 and 3; values left are 6 & 10 and 4
        - now we need to check if the three "left" values we chose are valid
            - that means B[2] < A[1] and A[1] <= B[3] (or smth like that if that makes sense)
            - if it's not, need to do binary search to find the right median (maybe watch video again to truly understand)

        */

        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2;

        // always keep A shorter
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0;
        int r = A.length;
        
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;

            int Aleft = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    return -1;


        
    }
}
