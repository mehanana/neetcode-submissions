class Solution {
    public int characterReplacement(String s, int k) {
        /*
        1. go through s (curChar is s(0))
        2. when we reach a value that does not equal curChar, add the index to the min heap
        3. if min heap size > k, pop from it and this is the new curchar
            - before setting this to curchar, see the length of cursubstring and if it's greater than the max, save this
        4. now use the new curchar and restart

        - find most freq character in the window
        - if the window length - freq > k, then that means we have to replace too many letters
        - so while windowLength - freq <= k, our window is valid
        - to figure out which is most freq, use int[] 
        */
        HashMap<Character, Integer> count = new HashMap();
        int res = 0;
        int left = 0;
        int right = 0;
        int maxValue = 0;
        
        while (right < s.length()) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxValue = Math.max(maxValue, count.get(s.charAt(right)));
            while ((right - left + 1) - maxValue > k) {
                // shift left pointer cuz not good window
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

/*
        int left = 0;
        int right = 1;
        PriorityQueue<Integer> minheap = new PriorityQueue();
        int res = 0;
        int curCount = 0;
        while (right < s.length() && left < right) {
            char curChar = s.charAt(left);
            if (s.charAt(right) == curChar) {
                right++;
            } else {
                if (minheap.size() < k) {
                    minheap.offer(right);
                    curCount++;
                    right++;
                } else {
                    left = minheap.poll();
                    res = Math.max(res, curCount);
                    curCount = 0;
                    minheap = new PriorityQueue();
                }
            }
        }
        return Math.max(res, curCount);
        */
        
    }
}
