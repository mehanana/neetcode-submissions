class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        use bucket sort algorithm to create n buckets
        group numbers based on their frequencies from 1 to n
        pick top k numbers from buckets starting from n to 1

        hashmap to keep track of freq like earlier
        array of lists to represent our buckets --> index of the array is the frequency, and the items in the lsit stored at that index are the numbers that show up in nums that many times

        1. go through nums and add to hashmap
        2. go through hashmap and add to bucket array
        3. go through bucket array (desc order) and go through each list in bucket array and add to res array until k items in array
        4. return result
        */

        // step 1
        Map<Integer, Integer> numFreq = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int n : nums) {
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        }


        // step 2
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        // step 3
        int[] result = new int[k];
        int idx = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> curList = buckets[i];
            for (int val : curList) {
                result[idx] = val;
                idx++;
                if (idx >= k) {
                    return result;
                }
            }
        }
        // step 4
        return result;
        
    }
}
