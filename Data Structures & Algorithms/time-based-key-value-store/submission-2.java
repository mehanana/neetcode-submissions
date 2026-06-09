class TimeMap {
    // time : (key : value)
    private HashMap<String, List<Pair<Integer, String>>> timeMap;
    
    public TimeMap() {
        this.timeMap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            timeMap.get(key).add(new Pair(timestamp, value));

        } else {
            timeMap.put(key, new ArrayList<>(Arrays.asList(new Pair<>(timestamp, value))));
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = timeMap.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = values.size()-1;
        String val = "";
        while (left <= right) {
            int mid = (left + right) / 2;
            if (values.get(mid).getKey() <= timestamp) {
                val = values.get(mid).getValue();
                left = mid+1;
            } else {
                right = mid - 1;
            }

        }
        return val;
        
    }
}

private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
