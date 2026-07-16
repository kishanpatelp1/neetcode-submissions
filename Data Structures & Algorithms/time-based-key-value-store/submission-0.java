class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) 
            map.put(key, new ArrayList<>());
        
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> res = map.get(key);
        int left = 0;
        int right = res.size()-1;
        String ans = "";
        while (left <= right) {
            int mid = left + (right - left)/2;

            if (res.get(mid).timestamp > timestamp) {
                right = mid -1;
            }
            else if (res.get(mid).timestamp < timestamp) {
                ans = res.get(mid).value;
                left = mid +1;
            }
            else return res.get(mid).value;
        }

        return ans;
    }
}

class Pair {
    String value;
    int timestamp;

    Pair (String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
