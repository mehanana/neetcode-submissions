class TimeMap {
    /*
    store key, value, and timestamp
    - can store multiple values for 1 key at the timestamp

    get the key's value at a specific timestamp

    i'm thinking hashmap of int[][] pair (key, value) to a value of the timestamp
    - looked at hints and it's actually key to int[][] (value, timestamp), which lowk makes more sense

    - needed to look at solution cuz i got confused since key can be repeated, we store list of pairs
    */

    Map<String, List<Pair>> timeMap;
    public TimeMap() {
       timeMap = new HashMap<>(); // key to value,timestamp pair
    }
    
    public void set(String key, String value, int timestamp) {
        /*
        all timestamps will be in increasing order
        */
        if (!timeMap.containsKey(key)) {
            List<Pair> toAdd = new ArrayList<>();
            toAdd.add(new Pair(value, timestamp));
            timeMap.put(key, toAdd);
        } else {
            timeMap.get(key).add(new Pair(value, timestamp));
        }
        
        
    }
    
    public String get(String key, int timestamp) {
        /*
        return the most recent value of key if set was called on it and the most recent timestamp for that is less than or equal to given timestamp
        if no values, return ""
        */

        List<Pair> pairs = timeMap.get(key);
        if (pairs == null) {
            return "";
        }

        int left = 0;
        int right = pairs.size()-1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (pairs.get(mid).getTimestamp() == timestamp) {
                return pairs.get(mid).getValue();
            } else if (pairs.get(mid).getTimestamp() < timestamp) {
                result = pairs.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
        
    }
}

class Pair {
    private String value;
    private int timeStamp;

    public Pair(String value, int timeStamp) {
        this.value = value;
        this.timeStamp = timeStamp;
    }

    public String getValue() {
        return value;
    }

    public int getTimestamp() {
        return timeStamp;
    }
}
